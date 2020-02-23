package com.example.apblue.jpahibernateexamples.serviceImpl;

import com.example.apblue.jpahibernateexamples.service.core.BaseService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Service
public abstract class BaseServiceImpl<E> implements BaseService<E> {

    @PersistenceContext
    protected EntityManager entityManager;
    private Class<E> persistentClass;

    public BaseServiceImpl() {
        this.persistentClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public List<E> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(persistentClass);
        Root<E> root = criteriaQuery.from(persistentClass);
        criteriaQuery.select(root);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public E merge(E entity) {
        return this.getEntityManager().merge(entity);
    }
}
