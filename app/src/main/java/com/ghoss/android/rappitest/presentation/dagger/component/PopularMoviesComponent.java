package com.ghoss.android.rappitest.presentation.dagger.component;

import com.ghoss.android.rappitest.presentation.dagger.CustomScope;
import com.ghoss.android.rappitest.presentation.dagger.module.PopularMoviesModule;
import com.ghoss.android.rappitest.presentation.view.activity.MainActivity;

import dagger.Subcomponent;

/**
 * Created by rrtatasciore on 14/10/17.
 */

@CustomScope
@Subcomponent(modules = PopularMoviesModule.class)
public interface PopularMoviesComponent {

    void inject(MainActivity activity);
}
