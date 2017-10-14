package com.ghoss.android.rappitest.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ghoss.android.rappitest.R;
import com.ghoss.android.rappitest.presentation.RappiApplication;
import com.ghoss.android.rappitest.presentation.presenter.PopularMoviesPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject PopularMoviesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((RappiApplication) getApplication()).getComponent()
                .popularMoviesComponent().inject(this);
        presenter.getPopularMovies();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.destroy();
    }
}
