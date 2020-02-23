package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.Actor;
import com.example.apblue.jpahibernateexamples.service.ActorService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/actor")
public class ActorCtrl implements FindAllCtrl<Actor> {

    private final ActorService actorService;

    @Autowired
    public ActorCtrl(ActorService actorService) {
        this.actorService = actorService;
    }


    @Override
    public BaseService<Actor> getService() {
        return this.actorService;
    }
}
