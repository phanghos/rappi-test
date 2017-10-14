package com.ghoss.android.rappitest.domain.executor;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by rrtatasciore on 13/10/17.
 */

public class MainThread {

    private static MainThread instance;
    private final Handler handler;

    private MainThread() {
        handler = new Handler(Looper.getMainLooper());
    }

    public static MainThread getInstance() {
        if (instance == null) {
            instance = new MainThread();
        }
        return instance;
    }

    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}
