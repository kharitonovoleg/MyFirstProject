package com.oleg.dao;

public class MyException extends Exception {

    private Exception hidden;

    public MyException (String message) {
        super(message);
    }

    public MyException(String message, Exception e) {
        super(message);
        hidden = e;
    }

    public Exception getHiddenException() {
        return hidden;
    }
}

