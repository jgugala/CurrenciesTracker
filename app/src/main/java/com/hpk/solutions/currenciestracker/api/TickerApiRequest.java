package com.hpk.solutions.currenciestracker.api;

/**
 * Created by $USER_NAME on 22.08.18.
 */
public class TickerApiRequest {

    private String method;

    private TickerApiRequestParams params;

    private int id;

    public TickerApiRequest(String tickerSymbol) {
        method = "subscribeTicker";
        id = 123;
        params = new TickerApiRequestParams(tickerSymbol);
    }
}
