package com.practicespringboot.usermanagement.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.practicespringboot.usermanagement.entities.Response;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private Response response;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        response.setMessage(message);
        return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullOrEmptyException.class)
    public ResponseEntity<Response> nullPointerException(NullOrEmptyException ex) {
        String message = ex.getMessage();
        response.setMessage(message);
        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
    }
}
