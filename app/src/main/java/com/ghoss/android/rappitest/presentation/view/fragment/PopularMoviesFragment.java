package com.ghoss.android.rappitest.presentation.view.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;
import com.ghoss.android.rappitest.R;
import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.presentation.RappiApplication;
import com.ghoss.android.rappitest.presentation.presenter.PopularMoviesPresenter;
import com.ghoss.android.rappitest.presentation.view.adapter.MovieAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roberto on 10/14/17.
 */

public class PopularMoviesFragment extends BasePresenterFragment<PopularMoviesPresenter> implements PopularMoviesPresenter.View {

    private static final String TAG = PopularMoviesFragment.class.getSimpleName();

    @Inject PopularMoviesPresenter presenter;

    @BindView(R.id.list) RecyclerView recyclerView;

    MovieAdapter movieAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_popular_movies, container, false);
        ButterKnife.bind(this, v);
        Drawable divider = ContextCompat.getDrawable(getContext(), R.drawable.divider);
        recyclerView.addItemDecoration(new DividerItemDecoration(divider));
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((RappiApplication) getActivity().getApplication())
                .getComponent().popularMoviesComponent().inject(this);
        setPresenter(presenter);
        getPresenter().setView(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().getPopularMovies();
    }

    @Override
    public void showProgress() {
        Log.d(TAG, "Loading");
    }

    @Override
    public void hideProgress() {
        Log.d(TAG, "Finished");
    }

    @Override
    public void showPopularMovies(List<Movie> movies) {
        if (movieAdapter == null) {
            movieAdapter = new MovieAdapter(movies);
            recyclerView.setAdapter(movieAdapter);
        } else {

        }
    }
}
