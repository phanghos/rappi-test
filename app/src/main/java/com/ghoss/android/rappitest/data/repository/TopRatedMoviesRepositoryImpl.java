package com.ghoss.android.rappitest.data.repository;

import com.ghoss.android.rappitest.data.entity.MovieEntity;
import com.ghoss.android.rappitest.data.entity.mapper.MovieEntityToMovieMapper;
import com.ghoss.android.rappitest.data.net.TmdbService;
import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.repository.TopRatedMoviesRepository;
import com.ghoss.android.rappitest.domain.usecase.UseCase;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by roberto on 10/14/17.
 */

public class TopRatedMoviesRepositoryImpl implements TopRatedMoviesRepository {

    private TmdbService service;
    private MovieEntityToMovieMapper mapper;

    @Inject
    public TopRatedMoviesRepositoryImpl(TmdbService service, MovieEntityToMovieMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public void getTopRatedMovies(final UseCase.Callback<List<Movie>> callback) {
        service.getTopRatedMovies(new UseCase.Callback<List<MovieEntity>>() {
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
