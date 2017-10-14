package com.ghoss.android.rappitest.presentation.dagger.component;

import com.ghoss.android.rappitest.presentation.dagger.CustomScope;
import com.ghoss.android.rappitest.presentation.dagger.module.TopRatedMoviesModule;
import com.ghoss.android.rappitest.presentation.view.fragment.TopRatedMoviesFragment;

import dagger.Subcomponent;

/**
 * Created by roberto on 10/14/17.
 */

@CustomScope
@Subcomponent(modules = TopRatedMoviesModule.class)
public interface TopRatedMoviesComponent {

    void inject(TopRatedMoviesFragment fragment);
}
