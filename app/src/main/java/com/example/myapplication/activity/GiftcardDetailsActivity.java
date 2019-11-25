package com.example.myapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.GiftcardDenominationAdapter;
import com.example.myapplication.model.Giftcard;
import com.example.myapplication.model.GiftcardDenomination;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GiftcardDetailsActivity extends AppCompatActivity {

    Giftcard giftcard;
    List<GiftcardDenomination> giftcardDenominationList;
    public ImageView ivGiftcard;
    public TextView tvBrand;
    public TextView tvVendor;
    public TextView tvDiscount;
    public TextView tvTerms;
    public Button btnCheckout;
    GridView gridViewDnm;
    Integer price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giftcard_details);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            giftcard = (Giftcard) bundle.getSerializable("giftcard");
        }

        ivGiftcard = findViewById(R.id.imageViewDetail);
        tvBrand = findViewById(R.id.tvBrand);
        tvVendor = findViewById(R.id.tvVendor);
        tvDiscount = findViewById(R.id.tvDiscount);
        gridViewDnm = findViewById(R.id.gridViewDnm);
        tvTerms = findViewById(R.id.tvTerms);
        btnCheckout = findViewById(R.id.btnCheckout);

        // loading gift card image using Picasso
        Picasso.get()
                .load(giftcard.getImage())
                .into(ivGiftcard);

        tvBrand.setText(giftcard.getBrand());
        tvVendor.setText(giftcard.getVendor());
        String discount = giftcard.getDiscount() + "% discount!";
        tvDiscount.setText(discount);

        //getting denominations
        giftcardDenominationList = giftcard.getDenominations();

        GiftcardDenominationAdapter giftcardDenominationAdapter = new GiftcardDenominationAdapter(this, giftcardDenominationList);
        gridViewDnm.setAdapter(giftcardDenominationAdapter);

        //getting value of selected denomination

        gridViewDnm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GiftcardDenomination giftcardDenomination = giftcardDenominationList.get(position);
                price = Integer.valueOf(giftcardDenomination.getPrice());


            }
        });

        // to read terms and conditions
        String text = "I understand Terms and Conditions";
        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {

                String terms = giftcard.getTerms();
                // using intent to move to another activity
                Intent intent = new Intent(getApplicationContext(), TermsActivity.class);
                //setting data of clicked gift
                intent.putExtra("terms", terms);
                startActivity(intent);
            }
        };

        ss.setSpan(clickableSpan, 13, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvTerms.setText(ss);
        tvTerms.setCursorVisible(true);
        tvTerms.setMovementMethod(LinkMovementMethod.getInstance());

        //for checkout
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (price == null){
                    Toast.makeText(getApplicationContext(), "Please select a denomination value!", Toast.LENGTH_SHORT).show();
                } else {
                    // open the giftcard checkout url in browser
                    String id = giftcard.getId();
                    String url = "https://zip.co/giftcards/checkout/" + id+ "?denominations=" + price;
                    Intent browserIntent = new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(url));
                    startActivity(browserIntent);
                }
            }
        });


    }
}
