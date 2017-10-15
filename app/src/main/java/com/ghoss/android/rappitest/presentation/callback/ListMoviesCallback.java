package com.ghoss.android.rappitest.presentation.callback;

import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.usecase.UseCase;
import com.ghoss.android.rappitest.presentation.presenter.PopularMoviesPresenter;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by roberto on 10/15/17.
 */

public class ListMoviesCallback implements UseCase.Callback<List<Movie>> {

    private WeakReference<PopularMoviesPresenter.View> viewRef;

    public void setView(PopularMoviesPresenter.View view) {
        viewRef = new WeakReference<>(view);
    }

    @Override
    public void onSuccess(List<Movie> result) {
        if (viewRef != null) {
            viewRef.get().showPopularMovies(result);
            viewRef.get().hideProgress();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        if (viewRef != null) {
            viewRef.get().hideProgress();
        }
    }
}
