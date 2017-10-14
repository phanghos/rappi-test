package com.ghoss.android.rappitest.domain.usecase;

import com.ghoss.android.rappitest.data.entity.MovieEntity;
import com.ghoss.android.rappitest.domain.executor.JobExecutor;
import com.ghoss.android.rappitest.domain.executor.MainThread;
import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.repository.MoviesRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by rrtatasciore on 14/10/17.
 */

public class GetPopularMoviesUseCase extends UseCase<Void, List<Movie>> {

    private MoviesRepository moviesRepository;

    @Inject
    public GetPopularMoviesUseCase(MoviesRepository moviesRepository, JobExecutor jobExecutor, MainThread mainThread) {
        super(jobExecutor, mainThread);
        this.moviesRepository = moviesRepository;
    }

    @Override
    public void run() {
        moviesRepository.getPopularMovies(new Callback<List<Movie>>() {
            @Override
            public void onSuccess(final List<Movie> result) {
                mainThread.post(new Runnable() {
                    @Override
                    public void run() {
                        if (useCaseCallbackk != null) {
                            useCaseCallbackk.onSuccess(result);
                        }
                    }
                });
            }

            @Override
            public void onError(final Throwable throwable) {
                mainThread.post(new Runnable() {
                    @Override
                    public void run() {
                        if (useCaseCallbackk != null) {
                            useCaseCallbackk.onError(throwable);
                        }
                    }
                });
            }
        });
    }

    @Override
    public void execute(Void param, Callback<List<Movie>> useCaseCallback) {
        this.useCaseCallbackk = useCaseCallback;
        jobExecutor.execute(this);
    }
}
