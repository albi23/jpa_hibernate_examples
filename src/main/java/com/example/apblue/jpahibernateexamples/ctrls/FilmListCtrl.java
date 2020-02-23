package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.FilmList;
import com.example.apblue.jpahibernateexamples.service.FilmListService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/filmlist")
public class FilmListCtrl implements FindAllCtrl<FilmList> {

    private final FilmListService filmListService;

    @Autowired
    public FilmListCtrl(FilmListService filmListService) {
        this.filmListService = filmListService;
    }


    @Override
    public BaseService<FilmList> getService() {
        return this.filmListService;
    }

}
