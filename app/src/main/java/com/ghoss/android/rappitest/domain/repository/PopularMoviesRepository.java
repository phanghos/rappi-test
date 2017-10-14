package com.ghoss.android.rappitest.domain.repository;

import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.usecase.UseCase;

import java.util.List;

/**
 * Created by rrtatasciore on 14/10/17.
 */

public interface PopularMoviesRepository {

    void getPopularMovies(UseCase.Callback<List<Movie>> callback);
}
