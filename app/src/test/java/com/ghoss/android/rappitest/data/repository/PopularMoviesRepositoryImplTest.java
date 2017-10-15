package com.ghoss.android.rappitest.data.repository;

import com.ghoss.android.rappitest.data.entity.MovieEntity;
import com.ghoss.android.rappitest.data.entity.mapper.MovieEntityToMovieMapper;
import com.ghoss.android.rappitest.data.net.TmdbService;
import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.repository.PopularMoviesRepository;
import com.ghoss.android.rappitest.domain.usecase.UseCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by roberto on 10/15/17.
 */
public class PopularMoviesRepositoryImplTest {

    PopularMoviesRepository repository;

    @Mock TmdbService service;

    @Mock MovieEntityToMovieMapper mapper;

    @Before
    public void setUp() {
        initMocks(this);
        repository = new PopularMoviesRepositoryImpl(service, mapper);
    }

    @Test
    public void checkNotNull() {
        assertNotNull(repository);
    }

    @Test
    public void getPopularMovies_onSuccess() {
        //Given
        final UseCase.Callback<List<Movie>> callback = mock(UseCase.Callback.class);
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle("title");
        final List<MovieEntity> movieEntities = new ArrayList<>();
        movieEntities.add(movieEntity);
        Movie movie = new Movie();
        movie.setTitle("title");
        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie);
        when(mapper.map(movieEntities)).thenReturn(movieList);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                callback.onSuccess(mapper.map(movieEntities));
                return null;
            }
        }).when(service).getPopularMovies(any(UseCase.Callback.class));

        //When
        repository.getPopularMovies(callback);

        //Then
        verify(service, times(1)).getPopularMovies(any(UseCase.Callback.class));
        verify(callback, times(1)).onSuccess(movieList);
        verify(mapper, times(1)).map(movieEntities);
        assertEquals(movie.getTitle(), movieEntity.getTitle());
        assertEquals(movieEntities.size(), movieList.size());
    }

    @Test
    public void getPopularMovies_onError() {
        //Given
        final UseCase.Callback<List<Movie>> callback = mock(UseCase.Callback.class);
        final Throwable t = new Throwable();
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                callback.onError(t);
                return null;
            }
        }).when(service).getPopularMovies(any(UseCase.Callback.class));

        //When
        repository.getPopularMovies(callback);

        //Then
        verify(service, times(1)).getPopularMovies(any(UseCase.Callback.class));
        verify(callback, times(1)).onError(t);
        verifyZeroInteractions(mapper);
    }
}