package com.hpk.solutions.currenciestracker.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hpk.solutions.currenciestracker.R;
import com.hpk.solutions.currenciestracker.databinding.ItemCurrenciesListBinding;
import com.hpk.solutions.currenciestracker.model.Currency;
import com.hpk.solutions.currenciestracker.view.CurrenciesListItemViewModel;

import java.util.List;

/**
 * Created by jgugala on 2018-08-21.
 */

public class CurrenciesAdapter extends RecyclerView.Adapter<CurrenciesAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(View view, Currency item, int position);
    }

    private List<Currency> currencies;

    private OnItemClickListener onItemClickListener;

    public CurrenciesAdapter(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final ItemCurrenciesListBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.item_currencies_list, parent, false
        );
        return new CurrenciesAdapter.ViewHolder(binding);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        final  Currency currency = currencies.get(position);
        final CurrenciesListItemViewModel itemViewModel =
                new CurrenciesListItemViewModel(currency);

        viewHolder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v, currency, position);
            }
        });
        viewHolder.bind(itemViewModel);
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ItemCurrenciesListBinding binding;

        ViewHolder(ItemCurrenciesListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(CurrenciesListItemViewModel itemViewModel) {
            binding.setViewModel(itemViewModel);
            binding.executePendingBindings();
        }
    }
}
