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
public class ProcessFlowSpecification_Update implements java.io.Serializable {
    private String lifecycleStatus;
    @OneToMany
    @JoinColumn(name = "ProcessFlowSpecification_Update_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @OneToMany
    @JoinColumn(name = "ProcessFlowSpecification_Update_id")
    @JsonManagedReference
    private List<RelatedEntitySpecification> relatedEntitySpecification;
    @OneToMany
    @JoinColumn(name = "ProcessFlowSpecification_Update_id")
    @JsonManagedReference
    private List<TaskFlowSpecificationRef> taskFlowSpecification;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProcessFlowSpecification_Update_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    @OneToMany
    @JoinColumn(name = "ProcessFlowSpecification_Update_id")
    @JsonManagedReference
    private List<CharacteristicSpecification> processFlowSpecificationCharacteristic;
    private String description;
    @OneToMany
    @JoinColumn(name = "ProcessFlowSpecification_Update_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private String version;
    @OneToMany
    @JoinColumn(name = "ProcessFlowSpecification_Update_id")
    @JsonManagedReference
    private List<ProcessFlowSpecificationRelationship> processFlowSpecificationRelationship;
}
