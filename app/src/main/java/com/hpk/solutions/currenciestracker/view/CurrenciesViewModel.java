package com.hpk.solutions.currenciestracker.view;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.support.annotation.NonNull;

import com.hpk.solutions.currenciestracker.api.HitBTCApi;
import com.hpk.solutions.currenciestracker.model.Currency;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jgugala on 2018-08-21.
 */

public class CurrenciesViewModel {

    private HitBTCApi hitBTCApi;

    ObservableArrayList<Currency> items = new ObservableArrayList<>();

    public ObservableBoolean inProgress = new ObservableBoolean(true);

    private Call<List<Currency>> call;

    @Inject
    public CurrenciesViewModel(HitBTCApi hitBTCApi) {
        this.hitBTCApi = hitBTCApi;
    }

    void getCurrenciesFromApi() {
        call = hitBTCApi.getCurrencySymbols();
        call.enqueue(callback);
    }

    void cancelRequest() {
        call.cancel();
    }

    private Callback<List<Currency>> callback = new Callback<List<Currency>>() {
        @Override
        public void onResponse(@NonNull Call<List<Currency>> call, @NonNull Response<List<Currency>> response) {
            items.clear();
            items.addAll(response.body());
            inProgress.set(false);
        }

        @Override
        public void onFailure(@NonNull Call<List<Currency>> call, @NonNull Throwable t) {
            inProgress.set(false);
        }
    };
}
