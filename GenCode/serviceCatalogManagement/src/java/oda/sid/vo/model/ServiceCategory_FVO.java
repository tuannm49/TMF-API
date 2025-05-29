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
public class ServiceCategory_FVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private String lifecycleStatus;
    private Boolean isRoot;
    @Embedded
    private TimePeriod validFor;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceCategory_FVO_ServiceCandidateRef_FVO")
    private List<ServiceCandidateRef_FVO> serviceCandidate;
    @JsonProperty("@type")
    private String type;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceCategory_FVO_ServiceSpecificationRef_FVO")
    private List<ServiceSpecificationRef_FVO> serviceSpecification;
    private String description;
    private String version;
    private String parentId;
    @JsonProperty("@baseType")
    private String baseType;
    private Date lastUpdate;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceCategory_FVO_ServiceCategoryRef_FVO")
    private List<ServiceCategoryRef_FVO> category;
}
