package oda.sid.vo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.util.logging.Logger;
import oda.sid.tmf.entity.others.*;
import oda.sid.tmf.entity.common.*;
import oda.sid.tmf.entity.customer.*;
import oda.sid.tmf.entity.party.*;
import oda.sid.tmf.entity.product.*;
import oda.sid.tmf.entity.resource.*;
import oda.sid.tmf.entity.sale.*;
import oda.sid.tmf.entity.service.*;
import oda.sid.tmf.entity.base.*;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category_FVO extends Entity_FVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private CategoryRef_FVO parent;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Category_FVO_CategoryRef_FVO")
    private List<CategoryRef_FVO> subCategory;
    private Boolean isRoot;
    private String lifecycleStatus;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Category_FVO_ProductOfferingRef_FVO")
    private List<ProductOfferingRef_FVO> productOffering;
    @Embedded
    private TimePeriod validFor;
    private Date lastUpdate;
    private String description;
    private String version;
}
