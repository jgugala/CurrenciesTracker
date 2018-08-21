package com.hpk.solutions.currenciestracker.api;

import java.util.Currency;
import java.util.List;

import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by jgugala on 2018-08-21.
 */

public interface HitBTCApi {

    public String BASE_URL = "https://api.hitbtc.com/";

    @GET("api/2/public/symbol")
    Response<List<Currency>> getCurrencySymbols();
}
