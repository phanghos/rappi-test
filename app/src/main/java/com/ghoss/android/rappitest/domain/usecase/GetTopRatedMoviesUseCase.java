package com.ghoss.android.rappitest.domain.usecase;

import com.ghoss.android.rappitest.domain.executor.JobExecutor;
import com.ghoss.android.rappitest.domain.executor.MainThread;
import com.ghoss.android.rappitest.domain.model.Movie;
import com.ghoss.android.rappitest.domain.repository.TopRatedMoviesRepository;

import java.util.List;

/**
 * Created by roberto on 10/14/17.
 */

public class GetTopRatedMoviesUseCase extends UseCase<Void, List<Movie>> {

    private TopRatedMoviesRepository repository;

    public GetTopRatedMoviesUseCase(TopRatedMoviesRepository repository, JobExecutor jobExecutor, MainThread mainThread) {
        super(jobExecutor, mainThread);
        this.repository = repository;
    }

    @Override
    public void run() {
        repository.getTopRatedMovies(new Callback<List<Movie>>() {
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
