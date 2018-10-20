package com.barath.app.controller;

import com.barath.app.entity.Actor;
import com.barath.app.entity.Actor;
import com.barath.app.service.ActorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping(value = "/actors", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ActorController {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping(value = "/new")
    public Actor addActor(@RequestBody Actor actor){

        return this.actorService.addActor(actor);
    }

    @PostMapping
    public List<Actor> addActors(@RequestBody List<Actor> actors){

        return this.actorService.addActors(actors);
    }

    @DeleteMapping("/{actorId}")
    public void deleteActor(@PathVariable Long actorId){
        this.actorService.deleteActor(actorId);
    }


    @GetMapping(value = "/{actorId}")
    public Actor getActorById(@PathVariable Long actorId ){

        return this.actorService.getActor(actorId);
    }

    @GetMapping(value = "/byName/{actorName}")
    public Actor getActorByActorName(@PathVariable String actorName ){

        return this.actorService.getActorByName(actorName);
    }


    @GetMapping
    public List<Actor> getActors(){

        return this.actorService.getAllActors();
    }
}
