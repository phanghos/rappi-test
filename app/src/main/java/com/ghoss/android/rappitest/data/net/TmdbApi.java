package com.ghoss.android.rappitest.data.net;

import com.ghoss.android.rappitest.data.entity.MovieResponseEntity;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rrtatasciore on 14/10/17.
 */

public interface TmdbApi {

    String BASE_URL = "https://themoviedb.org/3/";

    @GET("movie/popular?api_key=93aea0c77bc168d8bbce3918cefefa45")
    Call<MovieResponseEntity> getPopularMovies();

    @GET("movie/top_rated?api_key=93aea0c77bc168d8bbce3918cefefa45")
    Call<MovieResponseEntity> getTopRatedMovies();

    @GET("movie/upcoming?api_key=93aea0c77bc168d8bbce3918cefefa45")
    Call<MovieResponseEntity> getUpcomingMovies();
}
