package com.example.apblue.jpahibernateexamples.ctrls.core;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface FindAllCtrl<E> extends BaseCtrl<E> {

    @RequestMapping(
            method = {RequestMethod.GET},
            produces = {"application/json"},
            path = "/all"
    )
    @ResponseBody
    default List<E> findAll(){
        return this.doFindAll();
    }

    default List<E> doFindAll(){
        return this.getService().findAll();
    }
}
