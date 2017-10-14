package com.ghoss.android.rappitest.presentation.presenter;

import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.presentation.view.BaseView;

import java.util.List;

/**
 * Created by roberto on 10/14/17.
 */

public interface TopRatedMoviesPresenter extends BasePresenter<TopRatedMoviesPresenter.View> {

    interface View extends BaseView {

        void showProgress();

        void hideProgress();

        void showTopRatedMovies(List<Movie> movies);
    }

    void getTopRatedMovies();
}
