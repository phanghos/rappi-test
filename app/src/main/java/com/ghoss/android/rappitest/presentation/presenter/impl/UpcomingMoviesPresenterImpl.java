package com.ghoss.android.rappitest.presentation.presenter.impl;

import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.usecase.GetUpcomingMoviesUseCase;
import com.ghoss.android.rappitest.domain.usecase.UseCase;
import com.ghoss.android.rappitest.presentation.presenter.UpcomingMoviesPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by roberto on 10/14/17.
 */

public class UpcomingMoviesPresenterImpl implements UpcomingMoviesPresenter {

    private UpcomingMoviesPresenter.View view;
    private GetUpcomingMoviesUseCase useCase;

    @Inject
    public UpcomingMoviesPresenterImpl(GetUpcomingMoviesUseCase useCase) {
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
    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void getUpcomingMovies() {
        useCase.execute(null, new UseCase.Callback<List<Movie>>() {
            @Override
            public void onSuccess(List<Movie> result) {
                if (view != null) {
                    view.showUpcomingMovies(result);
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
