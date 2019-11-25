package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.model.GiftcardDenomination;

import java.util.List;

public class GiftcardDenominationAdapter extends ArrayAdapter<GiftcardDenomination> {
    private GiftcardDenomination giftcardDenomination;

    public GiftcardDenominationAdapter(Context context, List<GiftcardDenomination> giftcardDenominations) {
        super(context, R.layout.grid_view_items, giftcardDenominations);
        this.getContext();
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        giftcardDenomination = getItem(position);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.grid_view_items, null);

        TextView tvPrice = convertView.findViewById(R.id.tvPrice);
        TextView tvCurrency = convertView.findViewById(R.id.tvCurrency);

        tvPrice.setText(String.valueOf(giftcardDenomination.getPrice()));
        tvCurrency.setText(giftcardDenomination.getCurrency());
        return convertView;
    }
}
