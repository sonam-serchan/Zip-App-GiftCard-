package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.myapplication.R;

public class TermsActivity extends AppCompatActivity {

    private TextView tvTermsConditions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        tvTermsConditions = findViewById(R.id.tvTermsConditions);

        Intent intent = getIntent();
        String terms = intent.getExtras().getString("terms");
        tvTermsConditions.setText(terms);
        tvTermsConditions.setMovementMethod(new ScrollingMovementMethod());
    }
}
