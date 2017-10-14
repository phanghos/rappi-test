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
            m.setAdult(m.getAdult());
            m.setBackdropPath(m.getBackdropPath());
            m.setId(m.getId());
            m.setOriginalLanguage(m.getOriginalLanguage());
            m.setOriginalTitle(m.getOriginalTitle());
            m.setOverview(m.getOverview());
            m.setPopularity(m.getPopularity());
            m.setPosterPath(m.getPosterPath());
            m.setReleaseDate(m.getReleaseDate());
            m.setTitle(m.getTitle());
            m.setVideo(m.getVideo());
            m.setVoteAverage(m.getVoteAverage());
            m.setVoteCount(m.getVoteCount());
            movies.add(m);
        }
        return movies;
    }
}
