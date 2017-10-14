package com.ghoss.android.rappitest.presentation.view.fragment;

import android.support.v4.app.Fragment;

import com.ghoss.android.rappitest.presentation.presenter.BasePresenter;

/**
 * Created by roberto on 10/14/17.
 */

public class BasePresenterFragment<P extends BasePresenter> extends Fragment {

    private P presenter;

    @Override
    public void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.start();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.resume();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.destroy();
        }
    }

    public P getPresenter() {
        return presenter;
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }
}
