package com.ghoss.android.rappitest.presentation.view;

import com.ghoss.android.rappitest.domain.model.Movie;

import java.util.List;

/**
 * Created by roberto on 10/15/17.
 */

public interface ListMoviesView extends BaseView {

    void showProgress();

    void hideProgress();

    void showMovies(List<Movie> movies);
}
