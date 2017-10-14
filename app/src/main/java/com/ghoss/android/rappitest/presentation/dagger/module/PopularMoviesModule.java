package com.ghoss.android.rappitest.presentation.dagger.module;

import com.ghoss.android.rappitest.data.entity.mapper.MovieEntityToMovieMapper;
import com.ghoss.android.rappitest.data.net.TmdbService;
import com.ghoss.android.rappitest.data.repository.PopularMoviesRepositoryImpl;
import com.ghoss.android.rappitest.domain.executor.JobExecutor;
import com.ghoss.android.rappitest.domain.executor.MainThread;
import com.ghoss.android.rappitest.domain.repository.PopularMoviesRepository;
import com.ghoss.android.rappitest.domain.usecase.GetPopularMoviesUseCase;
import com.ghoss.android.rappitest.presentation.dagger.CustomScope;
import com.ghoss.android.rappitest.presentation.presenter.PopularMoviesPresenter;
import com.ghoss.android.rappitest.presentation.presenter.impl.PopularMoviesPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rrtatasciore on 14/10/17.
 */

@Module
public class PopularMoviesModule {

    @Provides
    @CustomScope
    public PopularMoviesPresenter providePopularMoviesPresenter(GetPopularMoviesUseCase useCase) {
        return new PopularMoviesPresenterImpl(useCase);
    }

    @Provides @CustomScope
    public GetPopularMoviesUseCase provideGetPopularMoviesUseCase(
            PopularMoviesRepository repository, JobExecutor jobExecutor, MainThread mainThread) {
        return new GetPopularMoviesUseCase(repository, jobExecutor, mainThread);
    }

    @Provides @CustomScope
    public PopularMoviesRepository provideMoviesRepository(TmdbService service, MovieEntityToMovieMapper mapper) {
        return new PopularMoviesRepositoryImpl(service, mapper);
    }

    @Provides @CustomScope
    public MovieEntityToMovieMapper provideMovieEntityToMovieMapper() {
        return new MovieEntityToMovieMapper();
    }
}
