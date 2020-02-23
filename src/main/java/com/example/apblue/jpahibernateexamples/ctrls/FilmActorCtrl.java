package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.FilmActor;
import com.example.apblue.jpahibernateexamples.service.FilmActorService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/filmactor")
public class FilmActorCtrl implements FindAllCtrl<FilmActor> {

    private final FilmActorService filmActorService;

    @Autowired
    public FilmActorCtrl(FilmActorService filmActorService) {
        this.filmActorService = filmActorService;
    }


    @Override
    public BaseService<FilmActor> getService() {
        return this.filmActorService;
    }

}
