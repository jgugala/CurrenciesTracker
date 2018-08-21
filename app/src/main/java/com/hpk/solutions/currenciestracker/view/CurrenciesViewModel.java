package com.hpk.solutions.currenciestracker.view;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hpk.solutions.currenciestracker.model.Currency;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by jgugala on 2018-08-21.
 */

public class CurrenciesViewModel {

    private static final String API_RESPONSE = "[\n" +
            "  {\n" +
            "    \"id\": \"BCNBTC\",\n" +
            "    \"baseCurrency\": \"BCN\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"100\",\n" +
            "    \"tickSize\": \"0.0000000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"BTCUSD\",\n" +
            "    \"baseCurrency\": \"BTC\",\n" +
            "    \"quoteCurrency\": \"USD\",\n" +
            "    \"quantityIncrement\": \"0.01\",\n" +
            "    \"tickSize\": \"0.01\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"USD\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"DASHBTC\",\n" +
            "    \"baseCurrency\": \"DASH\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.001\",\n" +
            "    \"tickSize\": \"0.000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"DOGEBTC\",\n" +
            "    \"baseCurrency\": \"DOGE\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"1000\",\n" +
            "    \"tickSize\": \"0.000000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"DOGEUSD\",\n" +
            "    \"baseCurrency\": \"DOGE\",\n" +
            "    \"quoteCurrency\": \"USD\",\n" +
            "    \"quantityIncrement\": \"10\",\n" +
            "    \"tickSize\": \"0.000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"USD\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"DSHBTC\",\n" +
            "    \"baseCurrency\": \"DSH\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"1\",\n" +
            "    \"tickSize\": \"0.000000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"EMCBTC\",\n" +
            "    \"baseCurrency\": \"EMC\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.1\",\n" +
            "    \"tickSize\": \"0.00000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"ETHBTC\",\n" +
            "    \"baseCurrency\": \"ETH\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.001\",\n" +
            "    \"tickSize\": \"0.000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"FCNBTC\",\n" +
            "    \"baseCurrency\": \"FCN\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.01\",\n" +
            "    \"tickSize\": \"0.000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"LSKBTC\",\n" +
            "    \"baseCurrency\": \"LSK\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.01\",\n" +
            "    \"tickSize\": \"0.0000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"LTCBTC\",\n" +
            "    \"baseCurrency\": \"LTC\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.1\",\n" +
            "    \"tickSize\": \"0.00001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"LTCUSD\",\n" +
            "    \"baseCurrency\": \"LTC\",\n" +
            "    \"quoteCurrency\": \"USD\",\n" +
            "    \"quantityIncrement\": \"0.1\",\n" +
            "    \"tickSize\": \"0.001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"USD\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"NXTBTC\",\n" +
            "    \"baseCurrency\": \"NXT\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"1\",\n" +
            "    \"tickSize\": \"0.00000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"SBDBTC\",\n" +
            "    \"baseCurrency\": \"SBD\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.001\",\n" +
            "    \"tickSize\": \"0.00001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"SCBTC\",\n" +
            "    \"baseCurrency\": \"SC\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"100\",\n" +
            "    \"tickSize\": \"0.000000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"STEEMBTC\",\n" +
            "    \"baseCurrency\": \"STEEM\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.001\",\n" +
            "    \"tickSize\": \"0.00001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"XDNBTC\",\n" +
            "    \"baseCurrency\": \"XDN\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"100\",\n" +
            "    \"tickSize\": \"0.0000000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"XEMBTC\",\n" +
            "    \"baseCurrency\": \"XEM\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"1\",\n" +
            "    \"tickSize\": \"0.00000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"XMRBTC\",\n" +
            "    \"baseCurrency\": \"XMR\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.01\",\n" +
            "    \"tickSize\": \"0.000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"ARDRBTC\",\n" +
            "    \"baseCurrency\": \"ARDR\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"1\",\n" +
            "    \"tickSize\": \"0.000000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"ZECBTC\",\n" +
            "    \"baseCurrency\": \"ZEC\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.001\",\n" +
            "    \"tickSize\": \"0.000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"WAVESBTC\",\n" +
            "    \"baseCurrency\": \"WAVES\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.01\",\n" +
            "    \"tickSize\": \"0.0000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"MAIDBTC\",\n" +
            "    \"baseCurrency\": \"MAID\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"1\",\n" +
            "    \"tickSize\": \"0.00000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"AMPBTC\",\n" +
            "    \"baseCurrency\": \"AMP\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.1\",\n" +
            "    \"tickSize\": \"0.00000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"BUSBTC\",\n" +
            "    \"baseCurrency\": \"BUS\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.0001\",\n" +
            "    \"tickSize\": \"0.00001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"DGDBTC\",\n" +
            "    \"baseCurrency\": \"DGD\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.001\",\n" +
            "    \"tickSize\": \"0.000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"ICNBTC\",\n" +
            "    \"baseCurrency\": \"ICN\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.001\",\n" +
            "    \"tickSize\": \"0.000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"SNGLSBTC\",\n" +
            "    \"baseCurrency\": \"SNGLS\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"1\",\n" +
            "    \"tickSize\": \"0.00000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"1STBTC\",\n" +
            "    \"baseCurrency\": \"1ST\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.001\",\n" +
            "    \"tickSize\": \"0.000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"TRSTBTC\",\n" +
            "    \"baseCurrency\": \"TRST\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"10\",\n" +
            "    \"tickSize\": \"0.00000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"TIMEBTC\",\n" +
            "    \"baseCurrency\": \"TIME\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.001\",\n" +
            "    \"tickSize\": \"0.000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"GNOBTC\",\n" +
            "    \"baseCurrency\": \"GNO\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.001\",\n" +
            "    \"tickSize\": \"0.000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"REPBTC\",\n" +
            "    \"baseCurrency\": \"REP\",\n" +
            "    \"quoteCurrency\": \"BTC\",\n" +
            "    \"quantityIncrement\": \"0.001\",\n" +
            "    \"tickSize\": \"0.000001\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"BTC\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"XMRUSD\",\n" +
            "    \"baseCurrency\": \"XMR\",\n" +
            "    \"quoteCurrency\": \"USD\",\n" +
            "    \"quantityIncrement\": \"0.001\",\n" +
            "    \"tickSize\": \"0.01\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"USD\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"id\": \"DASHUSD\",\n" +
            "    \"baseCurrency\": \"DASH\",\n" +
            "    \"quoteCurrency\": \"USD\",\n" +
            "    \"quantityIncrement\": \"0.001\",\n" +
            "    \"tickSize\": \"0.01\",\n" +
            "    \"takeLiquidityRate\": \"0.001\",\n" +
            "    \"provideLiquidityRate\": \"-0.0001\",\n" +
            "    \"feeCurrency\": \"USD\"\n" +
            "  }\n" +
            "]";

    @Inject
    public CurrenciesViewModel() {
    }

    List<Currency> getCurrencies() {
        Gson gson = new Gson();
        Type lisType = new TypeToken<List<Currency>>(){}.getType();
        return gson.fromJson(API_RESPONSE, lisType);
    }
}
