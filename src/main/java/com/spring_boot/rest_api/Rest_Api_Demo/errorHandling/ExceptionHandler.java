package com.spring_boot.rest_api.Rest_Api_Demo.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;

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

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<?> handleNumberFormatException(NumberFormatException exe){
        Map<String,Object> response=new HashMap<>();
        response.put("error", "Invalid data type");
        response.put("message",exe.getMessage());
        response.put("statusCode",HttpStatus.BAD_REQUEST.value());
        response.put("timeStamp",System.currentTimeMillis());

        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

    }
}
