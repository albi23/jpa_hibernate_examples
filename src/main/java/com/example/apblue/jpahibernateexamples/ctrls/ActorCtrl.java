package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.model.Actor;
import com.example.apblue.jpahibernateexamples.service.ActorService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/actor")
public class ActorCtrl {

    final ActorService actorService;

    public ActorCtrl(ActorService actorService) {
        this.actorService = actorService;
    }

    @CrossOrigin
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/all",
            produces = {"application/json"}
    )
    @Transactional
    public List<Actor> getAllMovies(){
        return actorService.getAll();
    }
}
