package com.itany.nmms.exception;

/**
 * Author:shixiaojun@itany.com
 * Date:2020/7/8-11:26
 */
public class ProductTypeExistException extends Exception {
    public ProductTypeExistException() {
    }

    public ProductTypeExistException(String message) {
        super(message);
    }

    public ProductTypeExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductTypeExistException(Throwable cause) {
        super(cause);
    }

    public ProductTypeExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
