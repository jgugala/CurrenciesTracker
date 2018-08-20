package com.hpk.solutions.currenciestracker.di.components;

import android.app.Application;

import com.hpk.solutions.currenciestracker.CurrenciesTrackerApp;
import com.hpk.solutions.currenciestracker.di.modules.ActivityModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, ActivityModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(CurrenciesTrackerApp app);
}
