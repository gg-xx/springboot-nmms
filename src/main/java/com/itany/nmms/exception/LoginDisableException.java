package com.itany.nmms.exception;

/**
 * Author:shixiaojun@itany.com
 * Date:2020/7/14-9:14
 */
public class LoginDisableException extends Exception {
    public LoginDisableException() {
    }

    public LoginDisableException(String message) {
        super(message);
    }

    public LoginDisableException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginDisableException(Throwable cause) {
        super(cause);
    }

    public LoginDisableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
