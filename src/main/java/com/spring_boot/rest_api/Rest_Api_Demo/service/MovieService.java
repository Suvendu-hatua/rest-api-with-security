package com.spring_boot.rest_api.Rest_Api_Demo.service;

import com.spring_boot.rest_api.Rest_Api_Demo.pojo.Movie;

import java.util.List;

public interface MovieService {

    public List<Movie> getAllMovies();
    public Movie getMovieById(long id);
    public Movie saveOrUpdate(Movie movie);
    public boolean deleteMovieById(long id);
    public List<Movie> sortMoviesByPubYear();
    public List<Movie> searchMovieByTitle(String title);
}
