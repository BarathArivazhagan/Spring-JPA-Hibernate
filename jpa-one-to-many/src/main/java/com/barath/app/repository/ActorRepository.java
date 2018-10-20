package com.barath.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barath.app.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor,Long> {


    Optional<Actor> findByActorName(String actorName);


}
