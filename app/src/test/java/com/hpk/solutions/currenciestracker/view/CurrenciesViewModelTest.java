package com.hpk.solutions.currenciestracker.view;

import com.hpk.solutions.currenciestracker.api.HitBTCApi;
import com.hpk.solutions.currenciestracker.model.Currency;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by jgugala on 2018-08-23.
 */
public class CurrenciesViewModelTest {

    @Test
    @SuppressWarnings("unchecked")
    public void getCurrenciesFromApi() {

        final HitBTCApi hitBTCApi = mock(HitBTCApi.class);
        final Call<List<Currency>> call = mock(Call.class);
        final Callback<List<Currency>> callback = mock(Callback.class);

        final CurrenciesViewModel viewModel = new CurrenciesViewModel(hitBTCApi);

        when(hitBTCApi.getCurrencySymbols()).thenReturn(call);

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) {
                callback.onResponse(call, Response.<List<Currency>>success(null));
                return null;
            }
        }).when(call).enqueue(any(Callback.class));

        viewModel.getCurrenciesFromApi();

        verify(call, times(1)).enqueue(any(Callback.class));
        verify(callback, times(1)).onResponse(any(Call.class), any(Response.class));
    }

}