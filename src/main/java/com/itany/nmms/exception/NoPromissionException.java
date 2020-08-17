package com.itany.nmms.exception;

/**
 * Author:shixiaojun@itany.com
 * Date:2020/7/15-9:17
 */
public class NoPromissionException extends Exception {
    public NoPromissionException() {
    }

    public NoPromissionException(String message) {
        super(message);
    }

    public NoPromissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPromissionException(Throwable cause) {
        super(cause);
    }

    public NoPromissionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
