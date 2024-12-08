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

import java.util.List;

@RestController
public class MovieController {

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
    public Movie getMovieById(@PathVariable("id") String strId) throws MovieNotFoundException {
        long id;
        try{
            id=Integer.parseInt(strId);
        }catch (NumberFormatException exe){
           throw new NumberFormatException("Valid Id format is required! ID must be of Integer.");
        }
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
    public ResponseEntity<?> deleteMovie(@PathVariable("id") String strId) throws MovieNotFoundException {
        long id;
        try{
            id=Integer.parseInt(strId);
        }catch (NumberFormatException exe){
            throw new NumberFormatException("Valid Id format is required! ID must be of Integer.");
        }

       boolean result=movieService.deleteMovieById(id);

       if(!result){
           throw new MovieNotFoundException("movie is not found with id: "+id+" so, can't be deleted.");
       }
       else{
           //for success--->
           SuccessResponse successResponse=new SuccessResponse(
                   "movie with id: "+id+" deleted successfully.",HttpStatus.OK.value(),System.currentTimeMillis()
           );
           return new ResponseEntity<SuccessResponse>(successResponse,HttpStatus.OK);
       }

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
