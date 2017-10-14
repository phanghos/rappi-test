package com.ghoss.android.rappitest.data.net;

import com.ghoss.android.rappitest.data.entity.MovieEntity;
import com.ghoss.android.rappitest.data.entity.MovieResponseEntity;
import com.ghoss.android.rappitest.domain.exception.TmdbApiException;
import com.ghoss.android.rappitest.domain.usecase.UseCase;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by rrtatasciore on 14/10/17.
 */

public class TmdbService {

    private TmdbApi api;

    @Inject
    public TmdbService(Retrofit retrofit) {
        api = retrofit.create(TmdbApi.class);
    }

    public void getPopularMovies(final UseCase.Callback<List<MovieEntity>> callback) {
        api.getPopularMovies().enqueue(new Callback<MovieResponseEntity>() {
            @Override
            public void onResponse(Call<MovieResponseEntity> call, Response<MovieResponseEntity> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body().getResults());
                } else {
                    callback.onError(new TmdbApiException());
                }
            }

            @Override
            public void onFailure(Call<MovieResponseEntity> call, Throwable t) {
                callback.onError(new TmdbApiException(t.getMessage()));
            }
        });
    }

    public void getTopRatedMovies(final UseCase.Callback<List<MovieEntity>> callback) {
        api.getTopRatedMovies().enqueue(new Callback<MovieResponseEntity>() {
            @Override
            public void onResponse(Call<MovieResponseEntity> call, Response<MovieResponseEntity> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body().getResults());
                } else {
                    callback.onError(new TmdbApiException());
                }
            }

            @Override
            public void onFailure(Call<MovieResponseEntity> call, Throwable t) {
                callback.onError(new TmdbApiException(t.getMessage()));
            }
        });
    }

    public void getUpcomingMovies(final UseCase.Callback<List<MovieEntity>> callback) {
        api.getUpcomingMovies().enqueue(new Callback<MovieResponseEntity>() {
            @Override
            public void onResponse(Call<MovieResponseEntity> call, Response<MovieResponseEntity> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body().getResults());
                } else {
                    callback.onError(new TmdbApiException());
                }
            }

            @Override
            public void onFailure(Call<MovieResponseEntity> call, Throwable t) {
                callback.onError(new TmdbApiException(t.getMessage()));
            }
        });
    }
}
