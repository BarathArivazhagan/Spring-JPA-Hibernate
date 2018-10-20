package com.barath.app.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="MOVIE")
public class Movie  implements Serializable {

	private static final long serialVersionUID = -6247909465626208625L;

	@Id
    @SequenceGenerator(name="movie_sequence", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_sequence")
    @Column(name="MOVIE_ID")
    private Long movieId;

    @Column(name="MOVIE_NAME")
    private String movieName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "movie")
    @JsonManagedReference
    private Set<Actor> actors;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                '}';
    }

    public Movie() {
    }

    public Movie(Long movieId, String movieName) {
        this.movieId = movieId;
        this.movieName = movieName;
    }

    public Movie(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(movieId, movie.movieId) &&
                Objects.equals(movieName, movie.movieName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, movieName);
    }
}
