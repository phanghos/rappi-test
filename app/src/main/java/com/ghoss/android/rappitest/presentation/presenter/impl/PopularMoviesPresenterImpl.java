package com.ghoss.android.rappitest.presentation.presenter.impl;

import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.usecase.GetPopularMoviesUseCase;
import com.ghoss.android.rappitest.domain.usecase.UseCase;
import com.ghoss.android.rappitest.presentation.presenter.PopularMoviesPresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by rrtatasciore on 14/10/17.
 */

public class PopularMoviesPresenterImpl implements PopularMoviesPresenter {

    private static final String TAG = PopularMoviesPresenterImpl.class.getSimpleName();

    private PopularMoviesPresenter.View view;
    private GetPopularMoviesUseCase useCase;

    @Inject
    public PopularMoviesPresenterImpl(GetPopularMoviesUseCase useCase) {
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
    public void getPopularMovies() {
        useCase.execute(null, new UseCase.Callback<List<Movie>>() {
            @Override
            public void onSuccess(List<Movie> result) {
                if (view != null) {
                    view.showPopularMovies(result);
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
