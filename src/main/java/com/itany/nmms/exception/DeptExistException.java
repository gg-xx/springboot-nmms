package com.itany.nmms.exception;

/**
 * Author:shixiaojun@itany.com
 * Date:2020/7/14-9:15
 */
public class DeptExistException extends Exception {
    public DeptExistException() {
    }

    public DeptExistException(String message) {
        super(message);
    }

    public DeptExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeptExistException(Throwable cause) {
        super(cause);
    }

    public DeptExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
