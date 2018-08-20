package com.hpk.solutions.currenciestracker.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hpk.solutions.currenciestracker.R;

import dagger.android.AndroidInjection;

public class CurrenciesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currencies);
    }
}
