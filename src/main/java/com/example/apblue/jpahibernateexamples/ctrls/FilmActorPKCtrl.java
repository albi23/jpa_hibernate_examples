package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.FilmActorPK;
import com.example.apblue.jpahibernateexamples.service.FilmActorPKService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/filmactorpk")
public class FilmActorPKCtrl implements FindAllCtrl<FilmActorPK> {

    private final FilmActorPKService filmActorPKService;

    @Autowired
    public FilmActorPKCtrl(FilmActorPKService filmActorPKService) {
        this.filmActorPKService = filmActorPKService;
    }


    @Override
    public BaseService<FilmActorPK> getService() {
        return this.filmActorPKService;
    }

}
