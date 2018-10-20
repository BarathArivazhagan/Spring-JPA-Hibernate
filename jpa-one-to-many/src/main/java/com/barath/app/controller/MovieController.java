package com.barath.app.controller;


import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barath.app.entity.Movie;
import com.barath.app.service.MovieService;

@RestController
@RequestMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MovieController {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(value = "/new")
    public Movie addMovie(@RequestBody Movie movie){

        return this.movieService.addMovie(movie);
    }

    @PostMapping
    public List<Movie> addMovies(@RequestBody List<Movie> movies){

        return this.movieService.addMovies(movies);
    }

    @DeleteMapping("/{movieId}")
    public void deleteMovie(@PathVariable Long movieId){
        this.movieService.deleteMovie(movieId);
    }


    @GetMapping(value = "/{movieId}")
    public Movie getMovieById(@PathVariable Long movieId ){

        return this.movieService.getMovie(movieId);
    }

    @GetMapping(value = "/byName/{movieName}")
    public Movie getMovieByMovieName(@PathVariable String movieName ){

        return this.movieService.getMovieByName(movieName);
    }


    @GetMapping
    public List<Movie> getMovies(){

        return this.movieService.getAllMovies();
    }
}
