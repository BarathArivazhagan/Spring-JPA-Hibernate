package com.barath.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="ACTOR")
public class Actor implements Serializable {

	
	private static final long serialVersionUID = -2222990964964188611L;

	@Id
    @SequenceGenerator(name="actor_sequence", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_sequence")
    @Column(name="ACTOR_ID")
    private Long actorId;

    @Column(name="ACTOR_NAME",nullable = false)
    private String actorName;

    @Column(name="ACTOR_AGE",nullable = false)
    private int actorAge;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MOVIE_ID")
    @JsonBackReference
    private Movie movie;

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public int getActorAge() {
        return actorAge;
    }

    public void setActorAge(int actorAge) {
        this.actorAge = actorAge;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", actorName='" + actorName + '\'' +
                ", actorAge=" + actorAge +
                '}';
    }

    public Actor() {
    }


    public Actor(String actorName, int actorAge) {
        this.actorId = actorId;
        this.actorName = actorName;
        this.actorAge = actorAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return actorAge == actor.actorAge &&
                Objects.equals(actorId, actor.actorId) &&
                Objects.equals(actorName, actor.actorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, actorName, actorAge);
    }
}
