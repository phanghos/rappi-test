package com.ghoss.android.rappitest.data.entity.mapper;

import com.ghoss.android.rappitest.data.entity.MovieEntity;
import com.ghoss.android.rappitest.domain.model.Movie;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by roberto on 10/15/17.
 */
public class MovieEntityToMovieMapperTest {

    MovieEntityToMovieMapper mapper;

    @Before
    public void setUp() {
        mapper = new MovieEntityToMovieMapper();
    }

    @Test
    public void checkNotNull() {
        assertNotNull(mapper);
    }

    @Test
    public void map_returnsExpectedObject() {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle("test");
        List<MovieEntity> movieEntityList = new ArrayList<>();
        movieEntityList.add(movieEntity);
        List<Movie> movieList = mapper.map(movieEntityList);
        assertEquals(movieList.size(), movieList.size());
        assertEquals(movieList.get(0).getTitle(), movieEntityList.get(0).getTitle());
    }
}