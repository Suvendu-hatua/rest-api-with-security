package com.spring_boot.rest_api.Rest_Api_Demo.dao;

import com.spring_boot.rest_api.Rest_Api_Demo.pojo.Movie;

import java.util.List;

public interface MovieCustomRepository {

    public List<Movie> sortMovieByPublicationYear();
    public List<Movie> searchMovieByTitle(String title);
}
