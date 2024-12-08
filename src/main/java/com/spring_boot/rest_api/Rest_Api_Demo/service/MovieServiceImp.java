package com.spring_boot.rest_api.Rest_Api_Demo.service;

import com.spring_boot.rest_api.Rest_Api_Demo.dao.MovieRepository;
import com.spring_boot.rest_api.Rest_Api_Demo.pojo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImp implements MovieService{
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImp(MovieRepository mr){
        this.movieRepository=mr;
    }
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(long id) {
        Optional<Movie> result =movieRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    @Transactional
    public Movie saveOrUpdate(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    @Transactional
    public boolean deleteMovieById(long id) {
        Movie movie=getMovieById(id);
        if(movie!=null){
            movieRepository.delete(movie);
            return true;
        }
        return false;
    }

    @Override
    public List<Movie> sortMoviesByPubYear() {
        return movieRepository.sortMovieByPublicationYear();
    }

    @Override
    public List<Movie> searchMovieByTitle(String title) {
        return movieRepository.searchMovieByTitle(title);
    }
}
