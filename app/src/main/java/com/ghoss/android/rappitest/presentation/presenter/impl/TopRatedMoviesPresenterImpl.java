package com.ghoss.android.rappitest.presentation.presenter.impl;

import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.usecase.GetTopRatedMoviesUseCase;
import com.ghoss.android.rappitest.domain.usecase.UseCase;
import com.ghoss.android.rappitest.presentation.presenter.TopRatedMoviesPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by roberto on 10/14/17.
 */

public class TopRatedMoviesPresenterImpl implements TopRatedMoviesPresenter {

    private TopRatedMoviesPresenter.View view;
    private GetTopRatedMoviesUseCase useCase;

    @Inject
    public TopRatedMoviesPresenterImpl(GetTopRatedMoviesUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void start() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void destroy() {
        view = null;
        useCase = null;
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void getTopRatedMovies() {
        useCase.execute(null, new UseCase.Callback<List<Movie>>() {
            @Override
            public void onSuccess(List<Movie> result) {
                if (view != null) {
                    view.showTopRatedMovies(result);
                }
            }

            @Override
            public void onError(Throwable throwable) {
                if (view != null) {

                }
            }
        });
    }
}
