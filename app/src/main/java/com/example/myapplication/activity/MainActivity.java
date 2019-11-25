package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.adapter.GiftcardsAdapter;
import com.example.myapplication.R;
import com.example.myapplication.model.Giftcard;
import com.example.myapplication.rest.GiftcardApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private GiftcardsAdapter adapter;
    private Button btnDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the reference of RecyclerView
        recyclerView = findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //create an instance of Retrofit

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://zip.co/giftcards/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final GiftcardApiService giftcardApiService = retrofit.create(GiftcardApiService.class);

        Call<List<Giftcard>> call = giftcardApiService.getGiftcards();

        call.enqueue(new Callback<List<Giftcard>>() {
            @Override
            public void onResponse(Call<List<Giftcard>> call, Response<List<Giftcard>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Not Successful", Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Not Successful");
                    return;
                }

                List<Giftcard> giftcardList = response.body();

                //  call the constructor of GiftcardsAdapter to send the reference and data to Adapter
                GiftcardsAdapter giftcardsAdapter = new GiftcardsAdapter(giftcardList);
                recyclerView.setAdapter(giftcardsAdapter); // set the Adapter to RecyclerView

                Log.e(TAG, "success");
            }

            @Override
            public void onFailure(Call<List<Giftcard>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e(TAG, t.toString());
            }
        });

    }


}
