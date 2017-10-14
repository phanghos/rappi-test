package com.ghoss.android.rappitest.presentation;

import android.app.Application;

import com.ghoss.android.rappitest.presentation.dagger.component.AppComponent;
import com.ghoss.android.rappitest.presentation.dagger.component.DaggerAppComponent;

/**
 * Created by rrtatasciore on 14/10/17.
 */

public class RappiApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().build();
        component.inject(this);
    }

    public AppComponent getComponent() {
        return component;
    }
}
