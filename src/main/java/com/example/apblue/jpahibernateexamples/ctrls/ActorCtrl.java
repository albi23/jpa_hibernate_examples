package com.example.apblue.jpahibernateexamples.ctrls;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/actor")
public class ActorCtrl {

    @CrossOrigin
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/all",
            produces = {"application/json"}
    )
    @Transactional
    public String getAllMovies(){
        return "test";
    }
}
