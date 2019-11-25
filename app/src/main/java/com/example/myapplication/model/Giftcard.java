package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Giftcard implements Serializable {

    private static final long serialVersionUID = 1L;

    @SerializedName("vendor")
    private String vendor;

    @SerializedName("id")
    private String id;

    @SerializedName("brand")
    private String brand;

    @SerializedName("image")
    private String image;

    @SerializedName("denominations")
    // transient
    private  List<GiftcardDenomination> denominations;

    @SerializedName("position")
    private Integer position;

    @SerializedName("discount")
    private Double discount;

    @SerializedName("terms")
    private String terms;

    @SerializedName("termsLink")
    private String termsLink;

    @SerializedName("isFixedValue")
    private Boolean isFixedValue;

    //constructor

    public Giftcard(String vendor, String brand, String id, String image, List<GiftcardDenomination> denominations, Integer position,
                    Double discount, String terms, String termsLink, Boolean isFixedValue) {
        this.vendor = vendor;
        this.brand = brand;
        this.id = id;
        this.image = image;
        this.denominations = denominations;
        this.position = position;
        this.discount = discount;
        this.terms = terms;
        this.termsLink = termsLink;
        this.isFixedValue = isFixedValue;
    }


    //getter and setter


    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<GiftcardDenomination> getDenominations() {
        return denominations;
    }

    public void setDenominations(List<GiftcardDenomination> denominations) {
        this.denominations = denominations;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getTermsLink() {
        return termsLink;
    }

    public void setTermsLink(String termsLink) {
        this.termsLink = termsLink;
    }

    public Boolean getFixedValue() {
        return isFixedValue;
    }

    public void setFixedValue(Boolean fixedValue) {
        isFixedValue = fixedValue;
    }
}
