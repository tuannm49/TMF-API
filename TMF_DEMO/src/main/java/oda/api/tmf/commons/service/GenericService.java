package oda.api.tmf.commons.service;

import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import oda.api.tmf.commons.base.ReferencedEntityGetter;
import oda.api.tmf.commons.database.DbmsDatabase;
import oda.api.tmf.commons.database.MongoDatabase;
import oda.api.tmf.commons.exceptions.BadUsageException;
import oda.api.tmf.commons.exceptions.UnknownResourceException;
import oda.api.tmf.commons.repository.DbmsRepository;
import oda.api.tmf.commons.repository.GenericRepository;
import oda.api.tmf.commons.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import javax.ws.rs.Path;
import javax.ws.rs.core.UriInfo;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    private final ReferencedEntityGetter<T> referencedEntityGetter;

    /**
     * Constructor for GenericService.
     *
     * @param dbType  the GenericRepository instance
     * @param entityClass the class of the entity
     */
    public GenericService(String dbType, Class<T> entityClass) {
        this.dbType = dbType;
        this.entityClass = entityClass;
        this.referencedEntityGetter = new ReferencedEntityGetter<>(entityClass);;
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
    public String buildHref(String url, String id) {
        if (url == null) {
            return null;
        }

        if (url.endsWith("/") == false) {
            url += "/";
        }

//        url += getRelativeEntityContext() + "/";
        if (id == null || id.length() <= 0) {
            return (url);
        }

        url += id;

        return url;
    }
    public String getRelativeEntityContext() {
        Path path = getClass().getAnnotation(Path.class);
        String value = (path != null) ? path.value() :  null;
        if (value == null) {
            return null;
        }

        int index = value.lastIndexOf("/");
        return (index >= 0) ? value.substring(index + 1) : value;
    }
    protected void getReferencedEntities(T entity, int depth) {
        referencedEntityGetter.getReferencedEntities(entity, depth);
    }

    /*
     *
     */
    protected void getReferencedEntities(Set<T> entities, int depth) {
        referencedEntityGetter.getReferencedEntities(entities, depth);
    }
    private T addHref(T entity,String url){
        try {
            // Lấy class của entity
            Class<?> clazz = entity.getClass();

            // Tìm field href
//            Field hrefField = clazz.getField("href");
            Field hrefField = findFieldInHierarchy(clazz, "href");
            // Tìm field id
            Field idField = findFieldInHierarchy(clazz, "id");
            // Cho phép truy cập private field
            hrefField.setAccessible(true);
            // Cho phép truy cập private id
            idField.setAccessible(true);

            // Gán giá trị cho field href (giả sử href là String)
            String hrefValue = buildHref(url,idField.get(entity).toString()); // Hàm để tạo giá trị href
            hrefField.set(entity, hrefValue);

        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot set href field", e);
        }

        // Thực hiện logic khác, ví dụ lưu entity vào database
        // saveToDatabase(entity);

        return entity;
    }
    private Field findFieldInHierarchy(Class<?> clazz, String fieldName) {
        Class<?> current = clazz;
        while (current != null) {
            try {
                return current.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                current = current.getSuperclass(); // Tìm trong superclass
            }
        }
        return null; // Không tìm thấy field
    }

}