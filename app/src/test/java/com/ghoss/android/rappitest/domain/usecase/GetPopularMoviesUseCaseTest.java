package com.ghoss.android.rappitest.domain.usecase;

import com.ghoss.android.rappitest.domain.executor.JobExecutor;
import com.ghoss.android.rappitest.domain.executor.MainThread;
import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.repository.PopularMoviesRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by roberto on 10/15/17.
 */
public class GetPopularMoviesUseCaseTest {

    GetPopularMoviesUseCase useCase;

    @Mock PopularMoviesRepository repository;

    @Mock JobExecutor jobExecutor;

    @Mock MainThread mainThread;

    @Before
    public void setUp() {
        initMocks(this);
        useCase = new GetPopularMoviesUseCase(repository, jobExecutor, mainThread);
    }

    @Test
    public void execute_onSuccess() {
        assertNotNull(useCase);
    }

    @Test
    public void run_onSuccess() {
        //Given
        final UseCase.Callback<List<Movie>> callback = mock(UseCase.Callback.class);
        Movie m = new Movie();
        final List<Movie> list = new ArrayList<>();
        list.add(m);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                callback.onSuccess(list);
                return null;
            }
        }).when(repository).getPopularMovies(any(UseCase.Callback.class));

        //When
        useCase.useCaseCallbackk = callback;
        useCase.run();

        //Then
        assertEquals(callback, useCase.useCaseCallbackk);
        verify(repository, times(1)).getPopularMovies(any(UseCase.Callback.class));
        verify(callback, times(1)).onSuccess(list);
    }

    @Test
    public void run_onError() {
        //Given
        final UseCase.Callback<List<Movie>> callback = mock(UseCase.Callback.class);
        final Throwable t = new Throwable();
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                callback.onError(t);
                return null;
            }
        }).when(repository).getPopularMovies(any(UseCase.Callback.class));

        //When
        useCase.useCaseCallbackk = callback;
        useCase.run();

        //Then
        assertEquals(callback, useCase.useCaseCallbackk);
        verify(repository, times(1)).getPopularMovies(any(UseCase.Callback.class));
        verify(callback, times(1)).onError(t);
    }
}