package com.hpk.solutions.currenciestracker.api;

import com.hpk.solutions.currenciestracker.model.Currency;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jgugala on 2018-08-21.
 */

public interface HitBTCApi {

    String BASE_URL = "https://api.hitbtc.com/";

    @GET("api/2/public/symbol")
    Call<List<Currency>> getCurrencySymbols();
}
