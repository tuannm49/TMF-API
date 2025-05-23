package oda.sid.vo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.util.logging.Logger;
import oda.sid.tmf.model.others.*;
import oda.sid.tmf.model.common.*;
import oda.sid.tmf.model.customer.*;
import oda.sid.tmf.model.party.*;
import oda.sid.tmf.model.product.*;
import oda.sid.tmf.model.resource.*;
import oda.sid.tmf.model.sale.*;
import oda.sid.tmf.model.service.*;
import oda.sid.tmf.model.base.*;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category_FVO extends Entity_FVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private CategoryRef_FVO parent;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Catg_FVO_subCatg")
    private List<CategoryRef_FVO> subCategory;
    private Boolean isRoot;
    private String lifecycleStatus;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Catg_FVO_productOffr")
    private List<ProductOfferingRef_FVO> productOffering;
    @Embedded
    private TimePeriod validFor;
    private Date lastUpdate;
    private String description;
    private String version;
}
