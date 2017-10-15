package com.ghoss.android.rappitest.presentation.presenter.impl;

import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.usecase.GetTopRatedMoviesUseCase;
import com.ghoss.android.rappitest.domain.usecase.UseCase;
import com.ghoss.android.rappitest.presentation.callback.ListMoviesCallback;
import com.ghoss.android.rappitest.presentation.presenter.TopRatedMoviesPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by roberto on 10/14/17.
 */

public class TopRatedMoviesPresenterImpl implements TopRatedMoviesPresenter {

    private TopRatedMoviesPresenter.View view;
    private GetTopRatedMoviesUseCase useCase;
    private ListMoviesCallback callback;

    @Inject
    public TopRatedMoviesPresenterImpl(GetTopRatedMoviesUseCase useCase, ListMoviesCallback callback) {
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
    public void getTopRatedMovies() {
        view.showProgress();
        useCase.execute(null, callback);
    }
}
