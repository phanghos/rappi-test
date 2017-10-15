package com.ghoss.android.rappitest.presentation.dagger.component;

import com.ghoss.android.rappitest.presentation.dagger.CustomScope;
import com.ghoss.android.rappitest.presentation.dagger.module.UpcomingMoviesModule;
import com.ghoss.android.rappitest.presentation.view.fragment.UpcomingMoviesFragment;

import dagger.Subcomponent;

/**
 * Created by roberto on 10/14/17.
 */

@CustomScope
@Subcomponent(modules = UpcomingMoviesModule.class)
public interface UpcomingMoviesComponent {

    void inject(UpcomingMoviesFragment fragment);
}
