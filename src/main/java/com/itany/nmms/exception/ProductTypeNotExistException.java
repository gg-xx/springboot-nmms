package com.itany.nmms.exception;

/**
 * Author:shixiaojun@itany.com
 * Date:2020/7/10-15:58
 */
public class ProductTypeNotExistException extends Exception {
    public ProductTypeNotExistException() {
    }

    public ProductTypeNotExistException(String message) {
        super(message);
    }

    public ProductTypeNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductTypeNotExistException(Throwable cause) {
        super(cause);
    }

    public ProductTypeNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
