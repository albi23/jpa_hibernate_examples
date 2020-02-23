package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.SalesByFilmCategory;
import com.example.apblue.jpahibernateexamples.service.SalesByFilmCategoryService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/salesbyfilmcategory")
public class SalesByFilmCategoryCtrl implements FindAllCtrl<SalesByFilmCategory> {

    private final SalesByFilmCategoryService salesByFilmCategoryService;

    @Autowired
    public SalesByFilmCategoryCtrl(SalesByFilmCategoryService salesByFilmCategoryService) {
        this.salesByFilmCategoryService = salesByFilmCategoryService;
    }


    @Override
    public BaseService<SalesByFilmCategory> getService() {
        return this.salesByFilmCategoryService;
    }

}
