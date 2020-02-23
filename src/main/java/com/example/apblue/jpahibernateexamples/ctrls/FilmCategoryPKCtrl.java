package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.FilmCategoryPK;
import com.example.apblue.jpahibernateexamples.service.FilmCategoryPKService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/filmcategorypk")
public class FilmCategoryPKCtrl implements FindAllCtrl<FilmCategoryPK> {

    private final FilmCategoryPKService filmCategoryPKService;

    @Autowired
    public FilmCategoryPKCtrl(FilmCategoryPKService filmCategoryPKService) {
        this.filmCategoryPKService = filmCategoryPKService;
    }


    @Override
    public BaseService<FilmCategoryPK> getService() {
        return this.filmCategoryPKService;
    }

}
