package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.FilmCategory;
import com.example.apblue.jpahibernateexamples.service.FilmCategoryService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/filmcategory")
public class FilmCategoryCtrl implements FindAllCtrl<FilmCategory> {

    private final FilmCategoryService filmCategoryService;

    @Autowired
    public FilmCategoryCtrl(FilmCategoryService filmCategoryService) {
        this.filmCategoryService = filmCategoryService;
    }


    @Override
    public BaseService<FilmCategory> getService() {
        return this.filmCategoryService;
    }

}
