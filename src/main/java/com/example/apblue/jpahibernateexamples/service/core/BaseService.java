package com.example.apblue.jpahibernateexamples.service.core;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<E> {
    List<E> findAll();

    E merge(E var1);
}
