package com.ghoss.android.rappitest.presentation.dagger.module;

import com.ghoss.android.rappitest.data.entity.mapper.MovieEntityToMovieMapper;
import com.ghoss.android.rappitest.data.net.TmdbService;
import com.ghoss.android.rappitest.data.repository.UpcomingMoviesRepositoryImpl;
import com.ghoss.android.rappitest.domain.executor.JobExecutor;
import com.ghoss.android.rappitest.domain.executor.MainThread;
import com.ghoss.android.rappitest.domain.repository.UpcomingMoviesRepository;
import com.ghoss.android.rappitest.domain.usecase.GetUpcomingMoviesUseCase;
import com.ghoss.android.rappitest.presentation.dagger.CustomScope;
import com.ghoss.android.rappitest.presentation.presenter.UpcomingMoviesPresenter;
import com.ghoss.android.rappitest.presentation.presenter.impl.UpcomingMoviesPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by roberto on 10/14/17.
 */

@Module
public class UpcomingMoviesModule {

    @Provides @CustomScope
    public UpcomingMoviesPresenter provideUpcomingMoviesPresenter(GetUpcomingMoviesUseCase useCase) {
        return new UpcomingMoviesPresenterImpl(useCase);
    }

    @Provides @CustomScope
    public GetUpcomingMoviesUseCase provideGetUpcomingMoviesUseCase(
            UpcomingMoviesRepository repository, JobExecutor jobExecutor, MainThread mainThread) {
        return new GetUpcomingMoviesUseCase(repository, jobExecutor, mainThread);
    }

    @Provides @CustomScope
    public UpcomingMoviesRepository provideUpcomingMoviesRepository(TmdbService service, MovieEntityToMovieMapper mapper) {
        return new UpcomingMoviesRepositoryImpl(service, mapper);
    }

    @Provides @CustomScope
    public MovieEntityToMovieMapper provideMovieEntityToMovieMapper() {
        return new MovieEntityToMovieMapper();
    }
}
