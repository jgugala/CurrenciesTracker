package com.hpk.solutions.currenciestracker.di.modules;

import com.hpk.solutions.currenciestracker.view.CurrenciesActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract CurrenciesActivity contributeCurrenciesActivity();
}
