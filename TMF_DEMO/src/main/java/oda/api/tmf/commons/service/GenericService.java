package oda.api.tmf.commons.service;

import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import oda.api.tmf.commons.database.DbmsDatabase;
import oda.api.tmf.commons.database.MongoDatabase;
import oda.api.tmf.commons.exceptions.BadUsageException;
import oda.api.tmf.commons.exceptions.UnknownResourceException;
import oda.api.tmf.commons.repository.DbmsRepository;
import oda.api.tmf.commons.repository.GenericRepository;
import oda.api.tmf.commons.repository.MongoRepository;
import oda.sid.tmf.model.base.CatalogEntityId;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * Generic service class for CRUD operations and querying entities.
 *
 * @param <T> the type of the entity
 */
@Slf4j
public class GenericService<T> {

    private GenericRepository<T> repository;
    private Class<T> entityClass;
    private final String dbType;
    private CatalogEntityId catalogEntityId = null;
    /**
     * Constructor for GenericService.
     *
     * @param dbType  the GenericRepository instance
     * @param entityClass the class of the entity
     */
    public GenericService(String dbType, Class<T> entityClass) {
        this.dbType = dbType;
        this.entityClass = entityClass;
        if("mysql".equals(dbType)){
            EntityManagerFactory entityManagerFactory =  DbmsDatabase.entityManagerFactory();
            repository = (GenericRepository<T>) new DbmsRepository<>(entityManagerFactory.createEntityManager(),entityClass);
        }else{
            repository = (GenericRepository<T>) new MongoRepository<>(MongoDatabase.mongoTemplate(),entityClass);
        }
        Class<?> superClass = entityClass.getSuperclass();
        if(superClass.getName().endsWith("AbstractCatalogEntity")){
            catalogEntityId = new CatalogEntityId();
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
    public T create(T entity, String url) throws BadUsageException,UnknownResourceException {
        T object = repository.create(entity);
        object = addHref(object,url);
        return update(object);
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
    public void delete(String id) throws UnknownResourceException {
        catalogEntityId.setId(id);
        repository.remove(catalogEntityId);
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
    public T findById(String id) throws UnknownResourceException {
        catalogEntityId.setId(id);
        return repository.find(catalogEntityId);
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



    public String buildHref(String url, String id) {
        if (url == null) {
            return null;
        }

        if (url.endsWith("/") == false) {
            url += "/";
        }

        if (id == null || id.length() <= 0) {
            return (url);
        }

        url += id;

        return url;
    }

    public T addHref(T entity, String url){
        try {
            Class<?> clazz = entity.getClass();

            Field hrefField = findFieldInHierarchy(clazz, "href");
            Field idField = findFieldInHierarchy(clazz, "id");
            hrefField.setAccessible(true);
            idField.setAccessible(true);

            String hrefValue = buildHref(url,idField.get(entity).toString());
            hrefField.set(entity, hrefValue);

        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot set href field", e);
        }

        return entity;
    }
    private Field findFieldInHierarchy(Class<?> clazz, String fieldName) {
        Class<?> current = clazz;
        while (current != null) {
            try {
                return current.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                current = current.getSuperclass();
            }
        }
        return null;
    }
}