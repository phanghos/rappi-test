package com.ghoss.android.rappitest.presentation.dagger.module;

import com.ghoss.android.rappitest.data.entity.mapper.MovieEntityToMovieMapper;
import com.ghoss.android.rappitest.data.net.TmdbService;
import com.ghoss.android.rappitest.data.repository.TopRatedMoviesRepositoryImpl;
import com.ghoss.android.rappitest.domain.executor.JobExecutor;
import com.ghoss.android.rappitest.domain.executor.MainThread;
import com.ghoss.android.rappitest.domain.repository.TopRatedMoviesRepository;
import com.ghoss.android.rappitest.domain.usecase.GetTopRatedMoviesUseCase;
import com.ghoss.android.rappitest.presentation.callback.ListMoviesCallback;
import com.ghoss.android.rappitest.presentation.dagger.CustomScope;
import com.ghoss.android.rappitest.presentation.presenter.TopRatedMoviesPresenter;
import com.ghoss.android.rappitest.presentation.presenter.impl.TopRatedMoviesPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by roberto on 10/14/17.
 */

@Module
public class TopRatedMoviesModule {

    @Provides @CustomScope
    public ListMoviesCallback provideListMoviesCallback() {
        return new ListMoviesCallback();
    }

    @Provides @CustomScope
    public TopRatedMoviesPresenter provideTopRatedMoviesPresenter(
            GetTopRatedMoviesUseCase useCase, ListMoviesCallback callback) {
        return new TopRatedMoviesPresenterImpl(useCase, callback);
    }

    @Provides @CustomScope
    public GetTopRatedMoviesUseCase provideGetTopRatedMoviesUseCase(
            TopRatedMoviesRepository repository, JobExecutor jobExecutor, MainThread mainThread) {
        return new GetTopRatedMoviesUseCase(repository, jobExecutor, mainThread);
    }

    @Provides @CustomScope
    public TopRatedMoviesRepository provideTopRatedMoviesRepository(
            TmdbService service, MovieEntityToMovieMapper mapper) {
        return new TopRatedMoviesRepositoryImpl(service, mapper);
    }

    @Provides @CustomScope
    public MovieEntityToMovieMapper provideMovieEntityToMovieMapper() {
        return new MovieEntityToMovieMapper();
    }
}
