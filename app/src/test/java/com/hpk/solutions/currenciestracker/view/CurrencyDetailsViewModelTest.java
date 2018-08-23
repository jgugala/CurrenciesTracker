package com.hpk.solutions.currenciestracker.view;

import com.google.gson.Gson;
import com.hpk.solutions.currenciestracker.model.Ticker;

import org.junit.Before;
import org.junit.Test;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by $USER_NAME on 23.08.18.
 */
public class CurrencyDetailsViewModelTest {

    private OkHttpClient okHttpClient;

    private Gson gson;

    private CurrencyDetailsViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        okHttpClient = mock(OkHttpClient.class);
        gson = mock(Gson.class);

        viewModel = new CurrencyDetailsViewModel(okHttpClient, gson);
    }


    @Test
    public void setTickerSymbol() {
        viewModel.setTickerSymbol("test_symbol");
        assertThat(viewModel.ticker.getSymbol(), is("test_symbol"));
    }

    @Test
    public void subscribeTicker() {
        viewModel.webSocket = mock(WebSocket.class);

        when(okHttpClient.newWebSocket(any(Request.class), any(WebSocketListener.class)))
                .thenReturn(viewModel.webSocket);
        when(gson.toJson(any(Object.class))).thenReturn("");

        viewModel.subscribeTicker();

        verify(okHttpClient, times(1))
                .newWebSocket(any(Request.class), any(WebSocketListener.class));
        verify(viewModel.webSocket, times(1)).send(anyString());
    }

    @Test
    public void unsubscribeTicker() {
        viewModel.webSocket = mock(WebSocket.class);

        viewModel.unsubscribeTicker();

        verify(viewModel.webSocket, times(1))
                .close(any(Integer.class), anyString());
    }

    @Test
    public void getTickerAsk() {
        viewModel.ticker.setAsk(12.45);
        assertEquals(viewModel.getTickerAsk(), "12.45");
    }

    @Test
    public void getTickerBid() {
        viewModel.ticker.setBid(13.7);
        assertEquals(viewModel.getTickerBid(), "13.7");
    }

    @Test
    public void updateTicker() {
        final Ticker ticker = new Ticker();

        ticker.setAsk(12.5);
        ticker.setBid(12.75);
        viewModel.ticker.setAsk(12.5);
        viewModel.ticker.setBid(12.6);

        viewModel.updateTicker(ticker);
        assertEquals(viewModel.getTickerBid(), "12.75");

    }
}