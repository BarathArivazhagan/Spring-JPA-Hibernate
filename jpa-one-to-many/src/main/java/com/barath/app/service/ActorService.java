package com.barath.app.service;

import com.barath.app.config.CacheNames;
import com.barath.app.entity.Actor;
import com.barath.app.entity.Movie;
import com.barath.app.exception.ActorNotFoundException;
import com.barath.app.repository.ActorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import javax.annotation.PostConstruct;
import javax.xml.ws.ServiceMode;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ActorService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @CacheEvict(value = CacheNames.ACTORS, allEntries = true)
    public Actor addActor(Actor actor){

        if(logger.isInfoEnabled()) { logger.info(" adding new actor {}", Objects.toString(actor)); }
        return this.actorRepository.save(actor);
    }

    @CacheEvict(value = CacheNames.ACTORS)
    public List<Actor> addActors(List<Actor> actors){

        if(logger.isInfoEnabled()) { logger.info(" adding new actors {}", Objects.toString(actors)); }
        return this.actorRepository.saveAll(actors);
    }

    @Cacheable(value = CacheNames.ACTORS)
    public Actor getActor(Long actorId){

        if(logger.isInfoEnabled()) { logger.info(" find actor {}", actorId); }
        Optional<Actor> optionalActor = this.actorRepository.findById(actorId);
        optionalActor.orElseThrow( () ->  new ActorNotFoundException(String.format("actor not found with actor id %d",actorId)));
        return  optionalActor.get() ;
    }

    @Cacheable(value = CacheNames.ACTORS)
    public List<Actor> getAllActors(){

        if(logger.isInfoEnabled()) { logger.info(" retriving all the actors {}"); }
        return this.actorRepository.findAll();
    }

    @Cacheable(value = CacheNames.ACTORS)
    public Actor getActorByName(String actorName){

        Optional<Actor> optionalActor =  this.actorRepository.findByActorName(actorName);
        optionalActor.orElseThrow( () ->  new ActorNotFoundException(String.format("actor not found with actor id %s",actorName)));
        return  optionalActor.get() ;
    }

    @CacheEvict(value = CacheNames.ACTORS)
    public void deleteActor(Long actorId){

        this.actorRepository.deleteById(actorId);
    }

    @PostConstruct
    public void setupActors(){

        Actor actor1 = new Actor("BARATH",26);
        Actor actor2 = new Actor("AJAY",25);
        Actor actor3 = new Actor("VIVEK",35);
        Movie movie1 = new Movie("OMEN");
        actor1.setMovie(movie1);
        actor2.setMovie(movie1);
        actor3.setMovie(movie1);
        this.addActors(Arrays.asList(actor1,actor2,actor3));

    }
}
