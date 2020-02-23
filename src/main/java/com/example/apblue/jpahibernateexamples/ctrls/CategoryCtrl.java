package com.example.apblue.jpahibernateexamples.ctrls;

import com.example.apblue.jpahibernateexamples.ctrls.core.FindAllCtrl;
import com.example.apblue.jpahibernateexamples.model.Category;
import com.example.apblue.jpahibernateexamples.service.CategoryService;
import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/category")
public class CategoryCtrl implements FindAllCtrl<Category> {

    private final CategoryService categoryService;

    @Autowired
    public CategoryCtrl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public BaseService<Category> getService() {
        return this.categoryService;
    }

}
