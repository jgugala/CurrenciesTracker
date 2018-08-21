package com.hpk.solutions.currenciestracker.model;

/**
 * Created by jgugala on 2018-08-21.
 */

public class Currency {

    private String id;

    private String baseCurrency;

    private String quoteCurrency;

    private float quantityIncrement;

    private double tickSize;

    private float takeLiquidityRate;

    private float provideLiquidityRate;

    private String feeCurrency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    public void setQuoteCurrency(String quoteCurrency) {
        this.quoteCurrency = quoteCurrency;
    }

    public float getQuantityIncrement() {
        return quantityIncrement;
    }

    public void setQuantityIncrement(float quantityIncrement) {
        this.quantityIncrement = quantityIncrement;
    }

    public double getTickSize() {
        return tickSize;
    }

    public void setTickSize(double tickSize) {
        this.tickSize = tickSize;
    }

    public float getTakeLiquidityRate() {
        return takeLiquidityRate;
    }

    public void setTakeLiquidityRate(float takeLiquidityRate) {
        this.takeLiquidityRate = takeLiquidityRate;
    }

    public float getProvideLiquidityRate() {
        return provideLiquidityRate;
    }

    public void setProvideLiquidityRate(float provideLiquidityRate) {
        this.provideLiquidityRate = provideLiquidityRate;
    }

    public String getFeeCurrency() {
        return feeCurrency;
    }

    public void setFeeCurrency(String feeCurrency) {
        this.feeCurrency = feeCurrency;
    }
}
