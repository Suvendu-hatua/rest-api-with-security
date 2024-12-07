package com.spring_boot.rest_api.Rest_Api_Demo.controller;

import com.spring_boot.rest_api.Rest_Api_Demo.pojo.Movie;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    private static List<Movie> movieList;

    @PostConstruct
    public void initializeMovies(){
        movieList=new ArrayList<>();
        movieList.add(new Movie(1001,"Pushpa 2","ISO12345","2024"));
        movieList.add(new Movie(1010,"Avengers","ISO12338","2025"));
        movieList.add(new Movie(1029,"Real Hero","ISON9980","2022"));
    }
    @RequestMapping(value = "/movies",method = RequestMethod.GET)
    public List<Movie> getAllMovies(){
        return movieList;
    }
    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable("id") int id){
        for (Movie movie:movieList){
            if(movie.getId()==id){
                return movie;
            }
        }
        return null;
    }
    @PutMapping("/movies")
    public Movie updateMovie(@RequestBody Movie movie){
        long id=movie.getId();
        for(Movie m:movieList){
            if(m.getId()==id){
                movieList.remove(m);
                movieList.add(movie);
                return movie;
            }
        }
        return null;

    }
    @PostMapping("/movies")
    public Movie saveMovie(@RequestBody Movie movie){
        movieList.add(movie);
        return movie;
    }
    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable("id") long id){
        for(Movie movie:movieList){
            if(movie.getId()==id){
                movieList.remove(movie);
                return;
            }
        }
        System.out.println("can't find the movie to be deleted."+id);
    }

}
