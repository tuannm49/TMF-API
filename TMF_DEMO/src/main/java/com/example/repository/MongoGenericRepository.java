package com.example.repository;

import com.example.model.Identifiable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

public class MongoGenericRepository<T extends Identifiable> implements GenericRepository<T> {

    private final MongoTemplate mongoTemplate;
    private final Class<T> entityClass;

    @Autowired
    public MongoGenericRepository(MongoTemplate mongoTemplate, Class<T> entityClass) {
        this.mongoTemplate = mongoTemplate;
        this.entityClass = entityClass;
    }

    @Override
    public T save(T entity) {
        mongoTemplate.save(entity);
        return entity;
    }

    @Override
    public T findById(String id) {
        return mongoTemplate.findById(id, entityClass);
    }
}