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
public class ServiceSpecification_FVO extends EntitySpecification_FVO implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceSpecification_FVO_ResourceSpecificationRef_FVO")
    private List<ResourceSpecificationRef_FVO> resourceSpecification;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private IntentSpecificationRef_FVO intentSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceSpecification_FVO_FeatureSpecification_FVO")
    private List<FeatureSpecification_FVO> featureSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceSpecification_FVO_ServiceLevelSpecificationRef_FVO")
    private List<ServiceLevelSpecificationRef_FVO> serviceLevelSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceSpecification_FVO_EntityRelationship_FVO")
    private List<EntityRelationship_FVO> serviceSpecRelationship;
}
