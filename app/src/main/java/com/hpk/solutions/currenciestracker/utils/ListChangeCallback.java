package com.hpk.solutions.currenciestracker.utils;

import android.databinding.ObservableList;

/**
 * Created by jgugala on 2018-08-21.
 */

public class ListChangeCallback<T> extends ObservableList.OnListChangedCallback<ObservableList<T>> {

    @Override
    public void onChanged(ObservableList<T> sender) {

    }

    @Override
    public void onItemRangeChanged(ObservableList<T> sender, int positionStart, int itemCount) {
        onChanged(sender);
    }

    @Override
    public void onItemRangeInserted(ObservableList<T> sender, int positionStart, int itemCount) {
        onChanged(sender);
    }

    @Override
    public void onItemRangeMoved(ObservableList<T> sender, int fromPosition, int toPosition, int itemCount) {
        onChanged(sender);
    }

    @Override
    public void onItemRangeRemoved(ObservableList<T> sender, int positionStart, int itemCount) {
        onChanged(sender);
    }
}
