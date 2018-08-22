package com.hpk.solutions.currenciestracker.view;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.hpk.solutions.currenciestracker.api.HitBTCApi;
import com.hpk.solutions.currenciestracker.api.TickerApiRequest;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/**
 * Created by $USER_NAME on 21.08.18.
 */
public class CurrencyDetailsViewModel {

    private static final int SOCKET_CLOSE_CODE = 1000;

    private OkHttpClient client;

    private Gson gson;

    private WebSocket webSocket;

    private String tickerSymbol;

    @Inject
    public CurrencyDetailsViewModel(OkHttpClient client, Gson gson) {
        this.client = client;
        this.gson = gson;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public void subscribeTicker() {
        final Request request = new Request.Builder().url(HitBTCApi.SOCKET_URL).build();
        webSocket = client.newWebSocket(request, webSocketListener);
        webSocket.send(createMessage(tickerSymbol));
    }

    public void unsubscribeTicker() {
        webSocket.close(SOCKET_CLOSE_CODE, "Component destroyed");
    }

    private String createMessage(String tickerSymbol) {
        final TickerApiRequest tickerApiRequest = new TickerApiRequest(tickerSymbol);
        return gson.toJson(tickerApiRequest);
    }

    private WebSocketListener webSocketListener = new WebSocketListener() {
        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            super.onOpen(webSocket, response);
        }

        @Override
        public void onMessage(WebSocket webSocket, String text) {
            super.onMessage(webSocket, text);
        }

        @Override
        public void onClosed(WebSocket webSocket, int code, String reason) {
            super.onClosed(webSocket, code, reason);
        }

        @Override
        public void onFailure(WebSocket webSocket, Throwable t, @Nullable Response response) {
            super.onFailure(webSocket, t, response);
        }
    };
}
