package com.ghoss.android.rappitest.presentation.dagger.component;

import com.ghoss.android.rappitest.presentation.RappiApplication;
import com.ghoss.android.rappitest.presentation.dagger.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rrtatasciore on 14/10/17.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(RappiApplication application);

    PopularMoviesComponent popularMoviesComponent();
    TopRatedMoviesComponent topRatedMoviesComponent();
    UpcomingMoviesComponent upcomingMoviesComponent();
}
