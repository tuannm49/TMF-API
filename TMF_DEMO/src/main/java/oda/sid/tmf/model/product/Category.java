package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import oda.sid.tmf.model.base.AbstractCatalogEntity;
import oda.sid.tmf.model.base.CatalogEntityId;
import oda.sid.tmf.model.base.EntityRef;
import oda.sid.tmf.model.base.TimePeriod;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@IdClass(CatalogEntityId.class)
public class Category extends AbstractCatalogEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    @OneToOne
    private EntityRef parent;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "subCategory_CategoryRef")
    private List<EntityRef> subCategory;
    private Boolean isRoot;
    private String lifecycleStatus;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "productOffering_ProductOfferingRef")
    private List<EntityRef> productOffering;
    @Embedded
    private TimePeriod validFor;
    private Date lastUpdate;
    private String description;
    private String version;
}
