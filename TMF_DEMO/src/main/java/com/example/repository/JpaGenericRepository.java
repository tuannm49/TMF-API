package com.example.repository;

import com.example.model.Identifiable;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class JpaGenericRepository<T extends Identifiable> implements GenericRepository<T> {

    private final EntityManager entityManager;
    private final Class<T> entityClass;

    @Autowired
    public JpaGenericRepository(EntityManager entityManager, Class<T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T findById(String id) {
        return entityManager.find(entityClass, id);
    }
}