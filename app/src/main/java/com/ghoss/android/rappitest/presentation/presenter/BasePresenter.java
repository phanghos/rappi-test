package com.ghoss.android.rappitest.presentation.presenter;

import com.ghoss.android.rappitest.presentation.view.BaseView;

/**
 * Created by rrtatasciore on 13/10/17.
 */

public interface BasePresenter<V extends BaseView> {

    void start();

    void resume();

    void destroy();

    void setView(V view);
}
