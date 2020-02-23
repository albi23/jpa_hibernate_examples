package com.example.apblue.jpahibernateexamples.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<E> {
    List<E> getAll();
}
