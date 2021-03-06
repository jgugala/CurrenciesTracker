package com.hpk.solutions.currenciestracker.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.hpk.solutions.currenciestracker.R;
import com.hpk.solutions.currenciestracker.adapter.CurrenciesAdapter;
import com.hpk.solutions.currenciestracker.databinding.ActivityCurrenciesBinding;
import com.hpk.solutions.currenciestracker.model.Currency;
import com.hpk.solutions.currenciestracker.utils.ListChangeCallback;
import com.hpk.solutions.currenciestracker.utils.RecyclerItemDecoration;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class CurrenciesActivity extends AppCompatActivity implements CurrenciesAdapter.OnItemClickListener, CurrenciesViewModel.RequestCallback {

    private CurrenciesAdapter adapter;

    @Inject
    CurrenciesViewModel viewModel;

    private ActivityCurrenciesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_currencies);
        binding.setViewModel(viewModel);
        viewModel.setRequestCallback(this);
        viewModel.getCurrenciesFromApi();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initRecyclerView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.cancelRequest();
        viewModel.items.removeOnListChangedCallback(listChangedCallback);
    }

    private void initRecyclerView() {
        adapter = new CurrenciesAdapter(viewModel.items);
        adapter.setOnItemClickListener(this);
        binding.currenciesList.setLayoutManager(new LinearLayoutManager(this));
        binding.currenciesList.addItemDecoration(
                new RecyclerItemDecoration(this, R.drawable.divider));
        binding.currenciesList.setAdapter(adapter);
        viewModel.items.addOnListChangedCallback(listChangedCallback);
    }

    @Override
    public void onItemClick(View view, Currency item, int position) {
        final Intent intent = new Intent(this, CurrencyDetailsActivity.class);
        intent.putExtra(CurrencyDetailsActivity.EXTRA_TICKER_SYMBOL, item.getId());
        startActivity(intent);
    }

    private ObservableList.OnListChangedCallback listChangedCallback =
            new ListChangeCallback<Currency>() {
                @Override
                public void onChanged(ObservableList sender) {
                    adapter.notifyDataSetChanged();
                }
            };

    @Override
    public void onFailure(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }
}
