package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import oda.sid.tmf.model.base.*;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category extends AbstractCatalogEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private CategoryRef parent;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Catg_subCatg")
    private List<CategoryRef> subCategory;
    private Boolean isRoot;
    private String lifecycleStatus;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Catg_productOffr")
    private List<ProductOfferingRef> productOffering;
    @Embedded
    private TimePeriod validFor;
    private Date lastUpdate;
    private String description;
    private String version;
}
