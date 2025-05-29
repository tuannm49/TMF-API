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
public class ServiceCategory_MVO extends Extensible implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String lifecycleStatus;
    private Boolean isRoot;
    @Embedded
    private TimePeriod validFor;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceCategory_MVO_ServiceCandidateRef_MVO")
    private List<ServiceCandidateRef_MVO> serviceCandidate;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceCategory_MVO_ServiceSpecificationRef_MVO")
    private List<ServiceSpecificationRef_MVO> serviceSpecification;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceCategory_MVO_ServiceCategoryRef_MVO")
    private List<ServiceCategoryRef_MVO> category;
    private String version;
    private String parentId;
}
