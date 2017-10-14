package com.ghoss.android.rappitest.domain.usecase;

import com.ghoss.android.rappitest.domain.executor.JobExecutor;
import com.ghoss.android.rappitest.domain.executor.MainThread;
import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.repository.UpcomingMoviesRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by roberto on 10/14/17.
 */

public class GetUpcomingMoviesUseCase extends UseCase<Void, List<Movie>> {

    private UpcomingMoviesRepository repository;

    @Inject
    public GetUpcomingMoviesUseCase(UpcomingMoviesRepository repository, JobExecutor jobExecutor, MainThread mainThread) {
        super(jobExecutor, mainThread);
        this.repository = repository;
    }

    @Override
    public void run() {
        repository.getUpcomingMovies(new Callback<List<Movie>>() {
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
    public void execute(Void param, final Callback<List<Movie>> useCaseCallback) {
        this.useCaseCallbackk = useCaseCallback;
        jobExecutor.execute(this);
    }
}
