package com.hpk.solutions.currenciestracker.api;

import com.hpk.solutions.currenciestracker.model.Ticker;

/**
 * Created by $USER_NAME on 22.08.18.
 */
public class TickerApiResponse {

    private String jsonrpc;

    private String method;

    private Ticker params;

    public Ticker getParams() {
        return params;
    }
}
