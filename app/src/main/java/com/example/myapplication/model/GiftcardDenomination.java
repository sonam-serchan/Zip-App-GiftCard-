package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GiftcardDenomination implements Serializable {

    @SerializedName("price")
    private Integer price;

    @SerializedName("currency")
    private String currency;

    public GiftcardDenomination(Integer price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
