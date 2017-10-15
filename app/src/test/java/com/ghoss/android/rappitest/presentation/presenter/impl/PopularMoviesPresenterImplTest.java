package com.ghoss.android.rappitest.presentation.presenter.impl;

import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.usecase.GetPopularMoviesUseCase;
import com.ghoss.android.rappitest.presentation.callback.ListMoviesCallback;
import com.ghoss.android.rappitest.presentation.presenter.PopularMoviesPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

    @Spy ListMoviesCallback callback;

    @Before
    public void setUp() {
        initMocks(this);
        presenter = new PopularMoviesPresenterImpl(useCase, callback);
        presenter.setView(view);
    }

    @Test
    public void checkNotNull() {
        assertNotNull(presenter);
        assertNotNull(useCase);
        assertNotNull(view);
        assertNotNull(callback);
    }

    @Test
    public void getView_returnsCorrectView() {
        assertEquals(view, presenter.getView());
    }

    @Test
    public void destroy_setsViewNull() {
        presenter.destroy();
        assertNull(presenter.getView());
    }

    @Test
    public void getPopularMovies_onSuccess() {
        //Given
        Movie m = new Movie();
        final List<Movie> list = new ArrayList<>();
        list.add(m);

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                callback.onSuccess(list);
                return null;
            }
        }).when(useCase).execute(null, callback);

        //When
        presenter.getPopularMovies();

        //Then
        verify(useCase, times(1)).execute(null, callback);
        verify(callback, times(1)).onSuccess(list);
        verify(view, times(1)).showProgress();
        verify(view, times(1)).hideProgress();
    }

    @Test
    public void getPopularMovies_onError() {
        //Given
        final Throwable t = new Throwable();

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                callback.onError(t);
                return null;
            }
        }).when(useCase).execute(null, callback);

        //When
        presenter.getPopularMovies();

        //Then
        verify(useCase, times(1)).execute(null, callback);
        verify(callback, times(1)).onError(t);
        verify(view, times(1)).showProgress();
        verify(view, times(1)).hideProgress();
    }
}