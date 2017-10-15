package com.ghoss.android.rappitest.presentation.presenter.impl;

import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.usecase.GetUpcomingMoviesUseCase;
import com.ghoss.android.rappitest.domain.usecase.UseCase;
import com.ghoss.android.rappitest.presentation.callback.ListMoviesCallback;
import com.ghoss.android.rappitest.presentation.presenter.UpcomingMoviesPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by roberto on 10/14/17.
 */

public class UpcomingMoviesPresenterImpl implements UpcomingMoviesPresenter {

    private UpcomingMoviesPresenter.View view;
    private GetUpcomingMoviesUseCase useCase;
    private ListMoviesCallback callback;

    @Inject
    public UpcomingMoviesPresenterImpl(GetUpcomingMoviesUseCase useCase, ListMoviesCallback callback) {
        this.useCase = useCase;
        this.callback = callback;
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
        callback.setView(null);
    }

    @Override
    public void setView(View view) {
        this.view = view;
        this.callback.setView(view);
    }

    @Override
    public void getUpcomingMovies() {
        view.showProgress();
        useCase.execute(null, callback);
    }
}
