package com.example.apblue.jpahibernateexamples.service;

import com.example.apblue.jpahibernateexamples.model.Actor;

import java.util.List;

public interface ActorService extends BaseService<Actor>{
    List<Actor> getAll();

}
