package com.hpk.solutions.currenciestracker.api;

/**
 * Created by $USER_NAME on 22.08.18.
 */
public class TickerApiResponseParams {

    private double ask;

    private double bid;

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getAsk() {
        return ask;
    }
}
