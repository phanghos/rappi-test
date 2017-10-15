package com.ghoss.android.rappitest.presentation.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ghoss.android.rappitest.R;
import com.ghoss.android.rappitest.presentation.view.fragment.PopularMoviesFragment;
import com.ghoss.android.rappitest.presentation.view.fragment.TopRatedMoviesFragment;
import com.ghoss.android.rappitest.presentation.view.fragment.UpcomingMoviesFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    TabsPagerAdapter pagerAdapter;

    @BindView(R.id.toolbar) Toolbar toolbar;

    @BindView(R.id.tabs) TabLayout tabLayout;

    @BindView(R.id.pager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setupViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager() {
        pagerAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        pagerAdapter.add("Popular", PopularMoviesFragment.newInstance());
        pagerAdapter.add("Top Rated", TopRatedMoviesFragment.newInstance());
        pagerAdapter.add("Upcoming", UpcomingMoviesFragment.newInstance());
        viewPager.setAdapter(pagerAdapter);
    }

    private class TabsPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> titles = new ArrayList<>();

        public TabsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        public void add(String title, Fragment f) {
            titles.add(title);
            fragments.add(f);
        }
    }
}
