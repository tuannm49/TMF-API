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
public class ServiceCatalog implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private String lifecycleStatus;
    @Embedded
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceCatalog_RelatedPartyRefOrPartyRoleRef")
    private List<EntityRef> relatedParty;
    private String version;
    @JsonProperty("@baseType")
    private String baseType;
    private Date lastUpdate;
    private String name;
    private String href;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ServiceCatalog_ServiceCategoryRef")
    private List<EntityRef> category;
}
