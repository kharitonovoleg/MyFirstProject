package com.oleg.dao;

public class DaoException extends Exception {

    private Exception hidden;

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Exception e) {
        super(message);
        hidden = e;
    }

    public Exception getHiddenException() {
        return hidden;
    }
}

