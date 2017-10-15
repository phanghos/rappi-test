package com.ghoss.android.rappitest.presentation.presenter.impl;

import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.usecase.GetPopularMoviesUseCase;
import com.ghoss.android.rappitest.domain.usecase.UseCase;
import com.ghoss.android.rappitest.presentation.presenter.PopularMoviesPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by roberto on 10/15/17.
 */
public class PopularMoviesPresenterImplTest {

    PopularMoviesPresenterImpl presenter;

    @Mock GetPopularMoviesUseCase useCase;

    @Mock PopularMoviesPresenter.View view;

    @Before
    public void setUp() {
        initMocks(this);
        presenter = new PopularMoviesPresenterImpl(useCase);
        presenter.setView(view);
    }

    @Test
    public void checkNotNull() {
        assertNotNull(presenter);
        assertNotNull(useCase);
        assertNotNull(view);
    }

    @Test
    public void getView_returnsCorrectView() {
        assertEquals(view, presenter.getView());
    }

    @Test
    public void getPopularMovies_onSuccess() {
        //Given
        final UseCase.Callback<List<Movie>> callback = mock(UseCase.Callback.class);
        Movie m = new Movie();
        final List<Movie> list = new ArrayList<>();
        list.add(m);

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                callback.onSuccess(list);
                return null;
            }
        }).when(useCase).execute(any(Void.class), any(UseCase.Callback.class));

        //When
        presenter.getPopularMovies();

        //Then
        verify(useCase, times(1)).execute(any(Void.class), any(UseCase.Callback.class));
        verify(callback, times(1)).onSuccess(list);
    }

    @Test
    public void getPopularMovies_onError() {
        //Given
        final UseCase.Callback<List<Movie>> callback = mock(UseCase.Callback.class);
        final Throwable t = new Throwable();

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                callback.onError(t);
                return null;
            }
        }).when(useCase).execute(any(Void.class), any(UseCase.Callback.class));

        //When
        presenter.getPopularMovies();

        //Then
        verify(useCase, times(1)).execute(any(Void.class), any(UseCase.Callback.class));
        verify(callback, times(1)).onError(t);
    }
}