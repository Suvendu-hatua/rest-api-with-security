package com.spring_boot.rest_api.Rest_Api_Demo.controller;

import com.spring_boot.rest_api.Rest_Api_Demo.pojo.Movie;
import com.spring_boot.rest_api.Rest_Api_Demo.service.MovieService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

//    private static List<Movie> movieList;

//    @PostConstruct
//    public void initializeMovies(){
//        movieList=new ArrayList<>();
//        movieList.add(new Movie(1001,"Pushpa 2","ISO12345","2024"));
//        movieList.add(new Movie(1010,"Avengers","ISO12338","2025"));
//        movieList.add(new Movie(1029,"Real Hero","ISON9980","2022"));
//    }

    private static  MovieService movieService;

    @Autowired
    public MovieController(MovieService ms){
        movieService=ms;
    }


    @RequestMapping(value = "/movies",method = RequestMethod.GET)
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }
    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable("id") long id){
       Movie movie=movieService.getMovieById(id);
       if(movie!=null){
           return  movie;
       }
       return null;
    }
    @PutMapping("/movies")
    public Movie updateMovie(@RequestBody Movie movie){
       return movieService.saveOrUpdate(movie);
    }

    @PostMapping("/movies")
    public Movie saveMovie(@RequestBody Movie movie){
        return movieService.saveOrUpdate(movie);
    }
    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable("id") long id){
       boolean result=movieService.deleteMovieById(id);
       if(result){
           System.out.println("deleted successfully.");
           return;
       }
        System.out.println("can't find the movie to be deleted."+id);
    }

    @GetMapping("/movies/sort")
    public List<Movie> sortMovieByYear(){
        return movieService.sortMoviesByPubYear();
    }

    @GetMapping("/movies/filter")
    public List<Movie> searchMovieByTitle(
            @RequestParam String title
    ){
            return movieService.searchMovieByTitle(title);
    }

}
