package com.itany.nmms.exception;

/**
 * Author:shixiaojun@itany.com
 * Date:2020/7/7-15:57
 */
public class RequestParameterErrorException extends Exception {
    public RequestParameterErrorException() {
    }

    public RequestParameterErrorException(String message) {
        super(message);
    }

    public RequestParameterErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestParameterErrorException(Throwable cause) {
        super(cause);
    }

    public RequestParameterErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
