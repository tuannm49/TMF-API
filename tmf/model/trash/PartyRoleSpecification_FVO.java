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
public class PartyRoleSpecification_FVO implements java.io.Serializable {
    private Boolean isBundle;
    private String lifecycleStatus;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "targetEntitySchema_id")
    @JsonBackReference
    private TargetEntitySchema_FVO targetEntitySchema;
    @OneToMany
    @JoinColumn(name = "PartyRoleSpecification_FVO_id")
    @JsonManagedReference
    private List<AgreementSpecificationRef_FVO> agreementSpecification;
    private String description;
    @OneToMany
    @JoinColumn(name = "PartyRoleSpecification_FVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_FVO> specCharacteristic;
    @OneToMany
    @JoinColumn(name = "PartyRoleSpecification_FVO_id")
    @JsonManagedReference
    private List<EntitySpecificationRelationship_FVO> entitySpecRelationship;
    @OneToMany
    @JoinColumn(name = "PartyRoleSpecification_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "PartyRoleSpecification_FVO_id")
    @JsonManagedReference
    private List<PermissionSpecificationSetRef_FVO> permissionSpecificationSet;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "PartyRoleSpecification_FVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue_FVO> attachment;
    private OffsetDateTime lastUpdate;
    private String name;
    @OneToMany
    @JoinColumn(name = "PartyRoleSpecification_FVO_id")
    @JsonManagedReference
    private List<ConstraintRef_FVO> constraint;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String status;
}
