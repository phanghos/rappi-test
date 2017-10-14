package com.ghoss.android.rappitest.domain.usecase;

import com.ghoss.android.rappitest.domain.executor.JobExecutor;
import com.ghoss.android.rappitest.domain.executor.MainThread;

import java.util.concurrent.Executor;

/**
 * Created by rrtatasciore on 13/10/17.
 */

public abstract class UseCase<P, R> implements Runnable {

    protected JobExecutor jobExecutor;
    protected MainThread mainThread;
    protected Callback<R> useCaseCallbackk;

    public UseCase(JobExecutor jobExecutor, MainThread mainThread) {
        this.jobExecutor = jobExecutor;
        this.mainThread = mainThread;
    }

    public interface Callback<R> {

        void onSuccess(R result);

        void onError(Throwable throwable);
    }

    public abstract void execute(P param, Callback<R> useCaseCallback);
}
