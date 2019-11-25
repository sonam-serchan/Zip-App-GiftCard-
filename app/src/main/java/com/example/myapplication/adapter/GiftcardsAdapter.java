package com.example.myapplication.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.widget.Toast;
import com.example.myapplication.R;
import com.example.myapplication.activity.GiftcardDetailsActivity;
import com.example.myapplication.model.Giftcard;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GiftcardsAdapter extends RecyclerView.Adapter<GiftcardsAdapter.GiftcardViewHolder> {

    private List<Giftcard> giftcardList;

    public GiftcardsAdapter(List<Giftcard> giftcardList) {
        this.giftcardList = giftcardList;
    }

    @Override
    public GiftcardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // infalte the item Layout
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        GiftcardViewHolder viewHolder = new GiftcardViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final GiftcardViewHolder holder, final int position) {

        // set the data in items

        String image_url = giftcardList.get(position).getImage();
        Picasso.get()
                .load(image_url)
                .into(holder.imageView);

        holder.brand.setText(giftcardList.get(position).getBrand());
        holder.vendor.setText(giftcardList.get(position).getVendor());

        //on click listenter event for button details

        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // using intent to move to another activity
                Intent intent = new Intent(view.getContext(), GiftcardDetailsActivity.class);
                //setting data of clicked gift
                Giftcard giftcard = giftcardList.get(position);
                //using bundle to pass the data through intent
                Bundle bundle = new Bundle();
                bundle.putSerializable("giftcard", giftcard);
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return giftcardList.size();
    }

    //A view holder inner class where we get reference to the views in the layout using their ID

    public static class GiftcardViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView brand;
        public TextView vendor;
        public Button btnDetails;
        public LinearLayout linearLayout;
        public GiftcardViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.brand = itemView.findViewById(R.id.brand);
            this.vendor = itemView.findViewById(R.id.vendor);
            this.btnDetails = itemView.findViewById(R.id.btnDetails);
            linearLayout = itemView.findViewById(R.id.linearLayout);
        }
    }
}
