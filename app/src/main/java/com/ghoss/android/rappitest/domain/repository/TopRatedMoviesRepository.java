package com.ghoss.android.rappitest.domain.repository;

import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.usecase.UseCase;

import java.util.List;

/**
 * Created by roberto on 10/14/17.
 */

public interface TopRatedMoviesRepository {

    void getTopRatedMovies(UseCase.Callback<List<Movie>> callback);
}
