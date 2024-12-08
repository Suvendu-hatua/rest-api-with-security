package com.spring_boot.rest_api.Rest_Api_Demo.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ErrorResponse> handleMovieNotFoundException(MovieNotFoundException exe){
        ErrorResponse err=new ErrorResponse();
        err.setMessage(exe.getMessage());
        err.setStatusCode(HttpStatus.NOT_FOUND.value());
        err.setTimeStamp(System.currentTimeMillis());
        return  new ResponseEntity<ErrorResponse>(err,HttpStatus.NOT_FOUND);
    }
}
