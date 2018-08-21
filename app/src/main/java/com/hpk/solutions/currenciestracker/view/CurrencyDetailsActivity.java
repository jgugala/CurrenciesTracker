package com.hpk.solutions.currenciestracker.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hpk.solutions.currenciestracker.R;
import com.hpk.solutions.currenciestracker.databinding.ActivityCurrencyDetailsBinding;

import dagger.android.AndroidInjection;

/**
 * Created by $USER_NAME on 21.08.18.
 */
public class CurrencyDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_TICKER_SYMBOL = "extra_ticket_symbol";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivityCurrencyDetailsBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_currency_details);
        setTitle("Currency Details");

        final String tickerSymbol = getIntent().getStringExtra(EXTRA_TICKER_SYMBOL);
        binding.tickerSymbol.setText(tickerSymbol);
    }
}
