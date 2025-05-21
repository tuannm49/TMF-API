package oda.sid.tmf.model.product;

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
import oda.sid.tmf.model.base.*;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category extends AbstractCatalogEntity implements java.io.Serializable {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="id", column=@Column(name = "parent_id")),
            @AttributeOverride(name="name", column=@Column(name = "parent_name")),
            @AttributeOverride(name="version", column=@Column(name = "parent_version")),
            @AttributeOverride(name="href", column=@Column(name = "parent_href")),
            @AttributeOverride(name="type", column=@Column(name = "parent_type")),
            @AttributeOverride(name="baseType", column=@Column(name = "parent_baseType")),
            @AttributeOverride(name="referredType", column=@Column(name = "parent_referredType")),
            @AttributeOverride(name="schemaLocation", column=@Column(name = "parent_schemaLocation"))
    })
    private CategoryRef parent;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_subCategory", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<CategoryRef> subCategory;
    private Boolean isRoot;
    private String lifecycleStatus;
    @ElementCollection
    @CollectionTable(name = "ProductOffering_productOffering", joinColumns = {
            @JoinColumn(name = "REF_ID",referencedColumnName = "id"),
            @JoinColumn(name = "REF_TYPE",referencedColumnName = "type")
    })
    private List<ProductOfferingRef> productOffering;
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="type", column=@Column(name = "target_type")),@AttributeOverride(name="schemaLocation", column=@Column(name = "target_schemaLocation"))})
    private TimePeriod validFor;
    private Date lastUpdate;
}
