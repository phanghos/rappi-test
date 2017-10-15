package com.ghoss.android.rappitest.presentation.presenter.impl;

import android.support.annotation.VisibleForTesting;

import com.ghoss.android.rappitest.domain.usecase.GetPopularMoviesUseCase;
import com.ghoss.android.rappitest.presentation.callback.ListMoviesCallback;
import com.ghoss.android.rappitest.presentation.presenter.PopularMoviesPresenter;

import javax.inject.Inject;

/**
 * Created by rrtatasciore on 14/10/17.
 */

public class PopularMoviesPresenterImpl implements PopularMoviesPresenter {

    private static final String TAG = PopularMoviesPresenterImpl.class.getSimpleName();

    private PopularMoviesPresenter.View view;
    private GetPopularMoviesUseCase useCase;
    private ListMoviesCallback callback;

    @Inject
    public PopularMoviesPresenterImpl(GetPopularMoviesUseCase useCase, ListMoviesCallback callback) {
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

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public View getView() {
        return view;
    }

    @Override
    public void getPopularMovies() {
        view.showProgress();
        useCase.execute(null, callback);
    }
}
