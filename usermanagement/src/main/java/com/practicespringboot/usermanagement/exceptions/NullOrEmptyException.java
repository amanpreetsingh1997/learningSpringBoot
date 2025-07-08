package com.practicespringboot.usermanagement.exceptions;

public class NullOrEmptyException extends RuntimeException {

    private String message;

    public NullOrEmptyException() {
    }

    public NullOrEmptyException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
