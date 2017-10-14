package com.ghoss.android.rappitest.presentation.dagger.module;

import com.ghoss.android.rappitest.data.net.TmdbApi;
import com.ghoss.android.rappitest.data.net.TmdbService;
import com.ghoss.android.rappitest.domain.executor.JobExecutor;
import com.ghoss.android.rappitest.domain.executor.MainThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rrtatasciore on 14/10/17.
 */

@Module
public class AppModule {

    @Provides @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(TmdbApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides @Singleton
    public TmdbService provideTmdbService(Retrofit retrofit) {
        return new TmdbService(retrofit);
    }

    @Provides @Singleton
    public JobExecutor provideJobExecutor() {
        return JobExecutor.getInstance();
    }

    @Provides @Singleton
    public MainThread provideMainThread() {
        return MainThread.getInstance();
    }
}
