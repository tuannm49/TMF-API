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
public class ProcessFlow_Create implements java.io.Serializable {
    private String processFlowSpecification;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ProcessFlow_Create_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    @OneToMany
    @JoinColumn(name = "ProcessFlow_Create_id")
    @JsonManagedReference
    private List<ChannelRef> channel;
    @ManyToOne
    @JoinColumn(name = "processFlowSpecificationRef_id")
    @JsonBackReference
    private ProcessFlowSpecificationRef processFlowSpecificationRef;
    @OneToMany
    @JoinColumn(name = "ProcessFlow_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "ProcessFlow_Create_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
}
