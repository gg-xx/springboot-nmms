package com.itany.nmms.exception;

/**
 * Author:shixiaojun@itany.com
 * Date:2020/7/14-13:35
 */
public class DeptException extends Exception {
    public DeptException() {
    }

    public DeptException(String message) {
        super(message);
    }

    public DeptException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeptException(Throwable cause) {
        super(cause);
    }

    public DeptException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
