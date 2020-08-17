package com.itany.nmms.exception;

/**
 * Author:shixiaojun@itany.com
 * Date:2020/7/13-9:16
 */
public class ProductExistException extends Exception {
    public ProductExistException() {
    }

    public ProductExistException(String message) {
        super(message);
    }

    public ProductExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductExistException(Throwable cause) {
        super(cause);
    }

    public ProductExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
