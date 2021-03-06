package com.ghoss.android.rappitest.domain.usecase;

import com.ghoss.android.rappitest.domain.executor.JobExecutor;
import com.ghoss.android.rappitest.domain.executor.MainThread;
import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.repository.PopularMoviesRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by rrtatasciore on 14/10/17.
 */

public class GetPopularMoviesUseCase extends UseCase<Void, List<Movie>> {

    private PopularMoviesRepository repository;

    @Inject
    public GetPopularMoviesUseCase(PopularMoviesRepository repository, JobExecutor jobExecutor, MainThread mainThread) {
        super(jobExecutor, mainThread);
        this.repository = repository;
    }

    @Override
    public void run() {
        repository.getPopularMovies(new Callback<List<Movie>>() {
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
