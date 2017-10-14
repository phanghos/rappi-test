package com.ghoss.android.rappitest.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ghoss.android.rappitest.R;
import com.ghoss.android.rappitest.presentation.view.fragment.PopularMoviesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new PopularMoviesFragment()).commit();
    }
}
