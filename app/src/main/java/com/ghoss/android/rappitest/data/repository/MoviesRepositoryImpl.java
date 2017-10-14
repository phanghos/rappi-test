package com.ghoss.android.rappitest.data.repository;

import com.ghoss.android.rappitest.data.entity.MovieEntity;
import com.ghoss.android.rappitest.data.entity.mapper.MovieEntityToMovieMapper;
import com.ghoss.android.rappitest.data.net.TmdbService;
import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.repository.MoviesRepository;
import com.ghoss.android.rappitest.domain.usecase.UseCase;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by rrtatasciore on 14/10/17.
 */

public class MoviesRepositoryImpl implements MoviesRepository {

    private TmdbService service;
    private MovieEntityToMovieMapper mapper;

    @Inject
    public MoviesRepositoryImpl(TmdbService service, MovieEntityToMovieMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public void getPopularMovies(final UseCase.Callback<List<Movie>> callback) {
        service.getPopularMovies(new UseCase.Callback<List<MovieEntity>>() {
            @Override
            public void onSuccess(List<MovieEntity> result) {
                if (callback != null) {
                    callback.onSuccess(mapper.map(result));
                }
            }

            @Override
            public void onError(Throwable throwable) {
                if (callback != null) {
                    callback.onError(throwable);
                }
            }
        });
    }
}
