package com.spring_boot.rest_api.Rest_Api_Demo.controller;

import com.spring_boot.rest_api.Rest_Api_Demo.errorHandling.MovieNotFoundException;
import com.spring_boot.rest_api.Rest_Api_Demo.errorHandling.SuccessResponse;
import com.spring_boot.rest_api.Rest_Api_Demo.pojo.Movie;
import com.spring_boot.rest_api.Rest_Api_Demo.service.MovieService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Movie getMovieById(@PathVariable("id") long id) throws MovieNotFoundException {
       Movie movie=movieService.getMovieById(id);
       if(movie==null){
           throw new MovieNotFoundException("movie is not found with id: "+id);
       }
       return  movie;
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
    public ResponseEntity<?> deleteMovie(@PathVariable("id") long id) throws MovieNotFoundException {
       boolean result=movieService.deleteMovieById(id);
       if(!result){
           throw new MovieNotFoundException("movie is not found with id: "+id+" so, can't be deleted.");
       }
       //for success--->
        SuccessResponse successResponse=new SuccessResponse(
                "movie with id: "+id+" deleted successfully.",HttpStatus.OK.value(),System.currentTimeMillis()
        );
       return new ResponseEntity<SuccessResponse>(successResponse,HttpStatus.OK);

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
