package com.barath.app.service;

import com.barath.app.config.CacheNames;
import com.barath.app.entity.Movie;
import com.barath.app.exception.MovieNotFoundException;
import com.barath.app.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @CacheEvict(value = CacheNames.MOVIES)
    public Movie addMovie(Movie movie){

        if(logger.isInfoEnabled()) { logger.info(" adding new movie {}", Objects.toString(movie)); }
        return this.movieRepository.save(movie);
    }

    @CacheEvict(value = CacheNames.MOVIES)
    public List<Movie> addMovies(List<Movie> movies){

        return this.movieRepository.saveAll(movies);
    }

    @Cacheable(value = CacheNames.MOVIES)
    public Movie getMovie(Long movieId){

        if(logger.isInfoEnabled()) { logger.info(" find movie {}", movieId); }
        Optional<Movie> optionalMovie = this.movieRepository.findById(movieId);
        optionalMovie.orElseThrow( () ->  new MovieNotFoundException(String.format("movie not found with movie id %d",movieId)));
        return  optionalMovie.get() ;
    }

    @Cacheable(value = CacheNames.MOVIES)
    public Movie getMovieByName(String movieName){

        if(logger.isInfoEnabled()) { logger.info(" find movie by moviename {}", movieName); }
        Optional<Movie> optionalMovie = this.movieRepository.findByMovieName(movieName);
        optionalMovie.orElseThrow( () ->  new MovieNotFoundException(String.format("movie not found with movie name %s",movieName)));
        return  optionalMovie.get() ;
    }

    @Cacheable(value = CacheNames.MOVIES)
    public List<Movie> getAllMovies(){

        if(logger.isInfoEnabled()) { logger.info(" retrieving all the movies {}"); }
        return this.movieRepository.findAll();
    }

    @CacheEvict(value = CacheNames.MOVIES)
    public void deleteMovie(Long movieId){
        this.movieRepository.deleteById(movieId);
    }
}
