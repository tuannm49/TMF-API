package com.example.commons.repository;

import com.example.commons.exceptions.BadUsageException;
import com.example.commons.exceptions.UnknownResourceException;
import java.util.List;
import java.util.Map;

/**
 * Generic repository interface for CRUD operations and querying entities.
 *
 * @param <T> the type of the entity
 */
public interface GenericRepository<T> {

    /**
     * Creates multiple entities.
     *
     * @param entities the list of entities to create
     * @return the number of entities created
     * @throws BadUsageException if the operation fails due to invalid usage
     */
    int create(List<T> entities) throws BadUsageException;

    /**
     * Creates a single entity.
     *
     * @param entity the entity to create
     * @throws BadUsageException if the operation fails due to invalid usage
     */
    T create(T entity) throws BadUsageException;

    /**
     * Updates an existing entity.
     *
     * @param entity the entity to update
     * @return the updated entity
     * @throws UnknownResourceException if the entity is not found
     */
    T edit(T entity) throws UnknownResourceException;

    /**
     * Removes an entity by its ID.
     *
     * @param id the ID of the entity to remove
     * @throws UnknownResourceException if the entity is not found
     */
    void remove(Object id) throws UnknownResourceException;

    /**
     * Removes all entities.
     */
    void removeAll();

    /**
     * Finds an entity by its ID.
     *
     * @param id the ID of the entity
     * @return the found entity
     * @throws UnknownResourceException if the entity is not found
     */
    T find(Object id) throws UnknownResourceException;

    /**
     * Detaches an entity from the persistence context.
     *
     * @param entity the entity to detach
     */
    void detach(T entity);

    /**
     * Clears the persistence context cache.
     */
    void clearCache();

    /**
     * Finds all entities.
     *
     * @return a list of all entities
     */
    List<T> findAll();

    /**
     * Finds entities within a specified range.
     *
     * @param range an array containing the start and end indices
     * @return a list of entities within the range
     */
    List<T> findRange(int[] range);

    /**
     * Counts the total number of entities.
     *
     * @return the total number of entities
     */
    int count();

    /**
     * Finds entities based on criteria.
     *
     * @param map a map of criteria key-value pairs
     * @param clazz the class of the entity
     * @return a list of entities matching the criteria
     */
    List<T> findByCriteria(Map<String, List<String>> map, Class<T> clazz);
}