package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.FilmText;
import com.example.apblue.jpahibernateexamples.service.FilmTextService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/filmtext")
public class FilmTextCtrl implements FindAllCtrl<FilmText> {

    private final FilmTextService filmTextService;

    @Autowired
    public FilmTextCtrl(FilmTextService filmTextService) {
        this.filmTextService = filmTextService;
    }


    @Override
    public BaseService<FilmText> getService() {
        return this.filmTextService;
    }

}
