package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.ActorInfo;
import com.example.apblue.jpahibernateexamples.service.ActorInfoService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/actorinfo")
public class ActorInfoCtrl implements FindAllCtrl<ActorInfo> {

    private final ActorInfoService actorInfoService;

    @Autowired
    public ActorInfoCtrl(ActorInfoService actorInfoService) {
        this.actorInfoService = actorInfoService;
    }


    @Override
    public BaseService<ActorInfo> getService() {
        return this.actorInfoService;
    }

}
