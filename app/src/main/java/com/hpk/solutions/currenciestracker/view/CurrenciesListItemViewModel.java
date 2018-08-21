package com.hpk.solutions.currenciestracker.view;

import com.hpk.solutions.currenciestracker.model.Currency;

/**
 * Created by jgugala on 2018-08-21.
 */

public class CurrenciesListItemViewModel {

    private Currency currency;

    public CurrenciesListItemViewModel(Currency currency) {
        this.currency = currency;
    }

    public String getPairName() {
        return currency.getBaseCurrency() + "/" + currency.getQuoteCurrency();
    }
}
