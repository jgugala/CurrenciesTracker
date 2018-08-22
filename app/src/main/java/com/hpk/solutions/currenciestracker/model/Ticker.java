package com.hpk.solutions.currenciestracker.model;

/**
 * Created by $USER_NAME on 22.08.18.
 */
public class Ticker {

    private String symbol;

    private double ask;

    private double bid;

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public double getBid() {
        return bid;
    }
}
