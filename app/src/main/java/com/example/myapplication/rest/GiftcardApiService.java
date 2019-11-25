package com.example.myapplication.rest;

import com.example.myapplication.model.Giftcard;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GiftcardApiService {

    @GET("api/giftcards")
    Call<List<Giftcard>> getGiftcards();


}
