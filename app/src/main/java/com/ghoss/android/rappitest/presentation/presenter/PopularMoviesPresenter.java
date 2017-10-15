package com.ghoss.android.rappitest.presentation.presenter;

import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.presentation.view.BaseView;
import com.ghoss.android.rappitest.presentation.view.ListMoviesView;

import java.util.List;

/**
 * Created by rrtatasciore on 14/10/17.
 */

public interface PopularMoviesPresenter extends BasePresenter<PopularMoviesPresenter.View> {

    interface View extends ListMoviesView {

    }

    void getPopularMovies();
}
