package com.example.apblue.jpahibernateexamples.ctrls.core;


import com.example.apblue.jpahibernateexamples.service.core.BaseService;

public interface BaseCtrl<E> {
    BaseService<E> getService();
}
