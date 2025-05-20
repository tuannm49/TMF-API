package oda.sid.vo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
import oda.sid.tmf.model.others.*;
import oda.sid.tmf.model.common.*;
import oda.sid.tmf.model.customer.*;
import oda.sid.tmf.model.party.*;
import oda.sid.tmf.model.product.*;
import oda.sid.tmf.model.resource.*;
import oda.sid.tmf.model.sale.*;
import oda.sid.tmf.model.service.*;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category_FVO extends Entity_FVO implements java.io.Serializable {
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parent_id")
    private CategoryRef_FVO parent;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Category_FVO_id")
    private List<CategoryRef_FVO> subCategory;
    private Boolean isRoot;
    private String lifecycleStatus;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "Category_FVO_id")
    private List<ProductOfferingRef_FVO> productOffering;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private TimePeriod validFor;
    private Date lastUpdate;
    private String name;
    private String description;
    private String version;
}
