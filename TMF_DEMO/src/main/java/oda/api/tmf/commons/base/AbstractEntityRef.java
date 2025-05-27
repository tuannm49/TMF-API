package oda.api.tmf.commons.base;

import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

/**
 *
 * @author bahman.barzideh
 *
 */
@MappedSuperclass
public abstract class AbstractEntityRef implements Serializable {

    public AbstractEntityRef() {
    }

    public abstract void fetchEntity(Class theClass, int depth);

}
