package oda.sid.tmf.model.base;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author bahman.barzideh
 *
 */
@Data
public class CatalogEntityId implements Serializable {
    private final static long serialVersionUID = 1L;

    private String catalogId = "1";
    private String catalogVersion = "1.0";
    private String id;



}
