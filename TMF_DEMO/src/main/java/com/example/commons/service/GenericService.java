package com.example.commons.service;

import com.example.commons.database.DbmsDatabase;
import com.example.commons.database.MongoDatabase;
import com.example.commons.exceptions.BadUsageException;
import com.example.commons.exceptions.UnknownResourceException;
import com.example.commons.repository.DbmsRepository;
import com.example.commons.repository.GenericRepository;
import com.example.commons.repository.MongoRepository;
import com.example.model.Product;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Generic service class for CRUD operations and querying entities.
 *
 * @param <T> the type of the entity
 */
public class GenericService<T> {

    private GenericRepository<T> repository;
    private Class<T> entityClass;
    private final String dbType;

    /**
     * Constructor for GenericService.
     *
     * @param repository  the GenericRepository instance
     * @param entityClass the class of the entity
     */
    public GenericService(String dbType,Class<T> entityClass) {
        this.dbType = dbType;
        this.entityClass = entityClass;
        if("mysql".equals(dbType)){
            EntityManagerFactory entityManagerFactory =  DbmsDatabase.entityManagerFactory();
            repository = (GenericRepository<T>) new DbmsRepository<>(entityManagerFactory.createEntityManager(),entityClass);
        }else{
            repository = (GenericRepository<T>) new MongoRepository<>(MongoDatabase.mongoTemplate(),entityClass);
        }
    }



    /**
     * Creates multiple entities.
     *
     * @param entities the list of entities to create
     * @return the number of entities created
     * @throws BadUsageException if the operation fails due to invalid usage
     */
    public int create(List<T> entities) throws BadUsageException {
        return repository.create(entities);
    }

    /**
     * Creates a single entity.
     *
     * @param entity the entity to create
     * @throws BadUsageException if the operation fails due to invalid usage
     */
    public T create(T entity) throws BadUsageException {
        return repository.create(entity);
    }

    /**
     * Updates an existing entity.
     *
     * @param entity the entity to update
     * @return the updated entity
     * @throws UnknownResourceException if the entity is not found
     */
    @Transactional
    public T update(T entity) throws UnknownResourceException {
        return repository.edit(entity);
    }

    /**
     * Deletes an entity by its ID.
     *
     * @param id the ID of the entity to delete
     * @throws UnknownResourceException if the entity is not found
     */
    public void delete(Object id) throws UnknownResourceException {
        repository.remove(id);
    }

    /**
     * Deletes all entities.
     */
    public void deleteAll() {
        repository.removeAll();
    }

    /**
     * Finds an entity by its ID.
     *
     * @param id the ID of the entity
     * @return the found entity
     * @throws UnknownResourceException if the entity is not found
     */
    public T findById(Object id) throws UnknownResourceException {
        return repository.find(id);
    }

    /**
     * Finds all entities.
     *
     * @return a list of all entities
     */
    public List<T> findAll() {
        return repository.findAll();
    }

    /**
     * Finds entities within a specified range.
     *
     * @param range an array containing the start and end indices
     * @return a list of entities within the range
     */
    public List<T> findRange(int[] range) {
        return repository.findRange(range);
    }

    /**
     * Counts the total number of entities.
     *
     * @return the total number of entities
     */
    public int count() {
        return repository.count();
    }

    /**
     * Finds entities based on criteria.
     *
     * @param map a map of criteria key-value pairs
     * @return a list of entities matching the criteria
     */
    public List<T> findByCriteria(Map<String, List<String>> map) {
        return repository.findByCriteria(map, entityClass);
    }
}