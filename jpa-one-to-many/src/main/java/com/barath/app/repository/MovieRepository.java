package com.barath.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barath.app.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    Optional<Movie> findByMovieName(String movieName);
}
