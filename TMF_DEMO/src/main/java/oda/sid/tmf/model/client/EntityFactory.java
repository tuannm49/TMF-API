package oda.sid.tmf.model.client;

import oda.sid.tmf.model.base.AbstractEntity;

import java.lang.reflect.Field;

public class EntityFactory {
    public EntityFactory() {
    }

    public <T extends AbstractEntity> T createEntity(T entity) throws IllegalAccessException {
        Class<?> entityClass = entity.getClass();
        Class<?> superClass = entityClass.getSuperclass();
        Boolean isCatalogEntity = superClass.getName().endsWith("AbstractCatalogEntity");

        if(isCatalogEntity){
            Field catalogId = findFieldInHierarchy(entityClass, "catalogId");
            Field catalogVersion = findFieldInHierarchy(entityClass, "catalogVersion");

            catalogId.setAccessible(true);
            catalogVersion.setAccessible(true);

            catalogId.set(entity,"1");
            catalogVersion.set(entity,"1.0");

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
