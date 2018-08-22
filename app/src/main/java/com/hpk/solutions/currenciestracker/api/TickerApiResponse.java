package com.hpk.solutions.currenciestracker.api;

/**
 * Created by $USER_NAME on 22.08.18.
 */
public class TickerApiResponse {

    private String jsonrpc;

    private String method;

    private TickerApiResponseParams params;

    public TickerApiResponseParams getParams() {
        return params;
    }
}
