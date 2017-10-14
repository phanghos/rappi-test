package com.ghoss.android.rappitest.data.entity.mapper;

import com.ghoss.android.rappitest.data.entity.MovieEntity;
import com.ghoss.android.rappitest.domain.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rrtatasciore on 14/10/17.
 */

public class MovieEntityToMovieMapper {

    public List<Movie> map(List<MovieEntity> movieEntities) {
        List<Movie> movies = new ArrayList<>();
        for (MovieEntity movieEntity : movieEntities) {
            Movie m = new Movie();
            m.setAdult(movieEntity.getAdult());
            m.setBackdropPath(movieEntity.getBackdropPath());
            m.setId(movieEntity.getId());
            m.setOriginalLanguage(movieEntity.getOriginalLanguage());
            m.setOriginalTitle(movieEntity.getOriginalTitle());
            m.setOverview(movieEntity.getOverview());
            m.setPopularity(movieEntity.getPopularity());
            m.setPosterPath(movieEntity.getPosterPath());
            m.setReleaseDate(movieEntity.getReleaseDate());
            m.setTitle(movieEntity.getTitle());
            m.setVideo(movieEntity.getVideo());
            m.setVoteAverage(movieEntity.getVoteAverage());
            m.setVoteCount(movieEntity.getVoteCount());
            movies.add(m);
        }
        return movies;
    }
}
