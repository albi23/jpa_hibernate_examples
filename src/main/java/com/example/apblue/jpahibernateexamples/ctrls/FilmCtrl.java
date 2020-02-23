package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.Film;
import com.example.apblue.jpahibernateexamples.service.FilmService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/film")
public class FilmCtrl implements FindAllCtrl<Film> {

    private final FilmService filmService;

    @Autowired
    public FilmCtrl(FilmService filmService) {
        this.filmService = filmService;
    }


    @Override
    public BaseService<Film> getService() {
        return this.filmService;
    }

}
