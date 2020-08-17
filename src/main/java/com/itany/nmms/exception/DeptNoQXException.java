package com.itany.nmms.exception;

public class DeptNoQXException extends Exception {

    public DeptNoQXException() {
        super();
    }

    public DeptNoQXException(String message) {
        super(message);
    }

    public DeptNoQXException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeptNoQXException(Throwable cause) {
        super(cause);
    }

    protected DeptNoQXException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
