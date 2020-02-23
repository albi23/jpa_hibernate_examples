package com.example.apblue.jpahibernateexamples.ctrls.core;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public interface CreateObjectCtrl<E> extends BaseCtrl<E> {

    @RequestMapping(
            method = {RequestMethod.POST},
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    default E createObject(@RequestBody E entity) {
        return this.getService().merge(entity);
    }
}
