package oda.sid.tmf.model.service;

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
@IdClass(CatalogEntityId.class)
public class ServiceSpecification extends AbstractCatalogEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceSpecification_ResourceSpecificationRef")
    private List<EntityRef> resourceSpecification;
    @OneToOne
    private EntityRef intentSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceSpecification_FeatureSpecification")
    private List<FeatureSpecification> featureSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceSpecification_ServiceLevelSpecificationRef")
    private List<EntityRef> serviceLevelSpecification;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceSpecification_EntityRelationship")
    private List<EntityRelationship> serviceSpecRelationship;
}
