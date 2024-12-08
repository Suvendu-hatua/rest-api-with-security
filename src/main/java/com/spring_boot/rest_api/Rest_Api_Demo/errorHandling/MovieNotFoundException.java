package com.spring_boot.rest_api.Rest_Api_Demo.errorHandling;

public class MovieNotFoundException extends Exception{

    public MovieNotFoundException(String message) {
        super(message);
    }
}
