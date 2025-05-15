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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntentSpecification_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "IntentSpecification_MVO_id")
    @JsonManagedReference
    private List<IntentSpecificationRelationship_MVO> intentSpecRelationship;
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
    private TargetEntitySchema_MVO targetEntitySchema;
    private String description;
    @OneToMany
    @JoinColumn(name = "IntentSpecification_MVO_id")
    @JsonManagedReference
    private List<CharacteristicSpecification_MVO> specCharacteristic;
    @OneToMany
    @JoinColumn(name = "IntentSpecification_MVO_id")
    @JsonManagedReference
    private List<EntitySpecificationRelationship_MVO> entitySpecRelationship;
    @OneToMany
    @JoinColumn(name = "IntentSpecification_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    private String version;
    @ManyToOne
    @JoinColumn(name = "expressionSpecification_id")
    @JsonBackReference
    private ExpressionSpecification_MVO expressionSpecification;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "IntentSpecification_MVO_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    private String name;
    @OneToMany
    @JoinColumn(name = "IntentSpecification_MVO_id")
    @JsonManagedReference
    private List<ConstraintRef_MVO> constraint;
    private String href;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
