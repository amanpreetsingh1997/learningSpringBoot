package com.practicespringboot.usermanagement.entities;

import org.springframework.stereotype.Component;

@Component
public class Response {
    
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
