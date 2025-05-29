package oda.sid.tmf.entity.service;

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
public class ServiceCategory implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private String lifecycleStatus;
    private Boolean isRoot;
    @Embedded
    private TimePeriod validFor;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceCategory_ServiceCandidateRef")
    private List<EntityRef> serviceCandidate;
    @JsonProperty("@type")
    private String type;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceCategory_ServiceSpecificationRef")
    private List<EntityRef> serviceSpecification;
    private String description;
    private String version;
    private String parentId;
    @JsonProperty("@baseType")
    private String baseType;
    private Date lastUpdate;
    private String href;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceCategory_ServiceCategoryRef")
    private List<EntityRef> category;
}
