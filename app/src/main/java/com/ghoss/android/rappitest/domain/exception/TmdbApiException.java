package com.ghoss.android.rappitest.domain.exception;

/**
 * Created by rrtatasciore on 14/10/17.
 */

public class TmdbApiException extends Exception {

    public TmdbApiException() {
        super();
    }

    public TmdbApiException(String msg) {
        super(msg);
    }

    public TmdbApiException(Throwable t) {
        super(t);
    }
}
