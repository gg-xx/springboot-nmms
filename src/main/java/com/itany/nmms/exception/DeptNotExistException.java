package com.itany.nmms.exception;

/**
 * Author:shixiaojun@itany.com
 * Date:2020/7/15-9:36
 */
public class DeptNotExistException extends Exception {
    public DeptNotExistException() {
    }

    public DeptNotExistException(String message) {
        super(message);
    }

    public DeptNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeptNotExistException(Throwable cause) {
        super(cause);
    }

    public DeptNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
