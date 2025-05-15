package com.example.trash;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClosedLoopSpecification_MVO implements java.io.Serializable {
    private Boolean isBundle;
    private OffsetDateTime creationdate;
    private String lifecycleStatus;
    private OffsetDateTime validfor;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "targetEntitySchema_id")
    @JsonBackReference
    private TargetEntitySchema_MVO targetEntitySchema;
    @ManyToOne
    @JoinColumn(name = "closedLoopType_id")
    @JsonBackReference
    private ClosedLoopType closedLoopType;
    private String description;
    @OneToMany
    @JoinColumn(name = "ClosedLoopSpecification_MVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_MVO> specCharacteristic;
    @OneToMany
    @JoinColumn(name = "ClosedLoopSpecification_MVO_id")
    @JsonManagedReference
    private List<EntitySpecificationRelationship_MVO> entitySpecRelationship;
    @OneToMany
    @JoinColumn(name = "ClosedLoopSpecification_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    private String version;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "ClosedLoopSpecification_MVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_MVO> attachment;
    private OffsetDateTime lastUpdate;
    private String name;
    @ManyToOne
    @JoinColumn(name = "closedLoopGroup_id")
    @JsonBackReference
    private ClosedLoopGroup_MVO closedLoopGroup;
    @OneToMany
    @JoinColumn(name = "ClosedLoopSpecification_MVO_id")
    @JsonManagedReference
    private List<ConstraintRef_MVO> constraint;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
