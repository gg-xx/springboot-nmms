package com.itany.nmms.exception;

/**
 * Author:shixiaojun@itany.com
 * Date:2020/7/7-16:02
 */
public class StaffNotExistException extends Exception {
    public StaffNotExistException() {
    }

    public StaffNotExistException(String message) {
        super(message);
    }

    public StaffNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public StaffNotExistException(Throwable cause) {
        super(cause);
    }

    public StaffNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
