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
public class Category_MVO extends Entity_MVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private CategoryRef_MVO parent;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Category_MVO_CategoryRef_MVO")
    private List<CategoryRef_MVO> subCategory;
    private Boolean isRoot;
    private String lifecycleStatus;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Category_MVO_ProductOfferingRef_MVO")
    private List<ProductOfferingRef_MVO> productOffering;
    @Embedded
    private TimePeriod validFor;
    private String description;
    private String version;
}
