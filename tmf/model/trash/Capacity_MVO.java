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
public class Capacity_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Capacity_MVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRef_MVO> relatedPlace;
    @ManyToOne
    @JoinColumn(name = "capacityStatus_id")
    @JsonBackReference
    private CapacityStatus capacityStatus;
    @OneToMany
    @JoinColumn(name = "Capacity_MVO_id")
    @JsonManagedReference
    private List<ApplicableTimePeriod_MVO> applicableTimePeriod;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "capacityAmount_id")
    @JsonBackReference
    private Quantity capacityAmount;
    @ManyToOne
    @JoinColumn(name = "capacityAmountFrom_id")
    @JsonBackReference
    private Quantity capacityAmountFrom;
    @ManyToOne
    @JoinColumn(name = "capacitySpecification_id")
    @JsonBackReference
    private CapacitySpecificationRef_MVO capacitySpecification;
    private String rangeInterval;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "Capacity_MVO_id")
    @JsonManagedReference
    private List<Capacity_MVO> relatedCapacity;
    @ManyToOne
    @JoinColumn(name = "capacityAmountTo_id")
    @JsonBackReference
    private Quantity capacityAmountTo;
    private String name;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Capacity_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> capacityCharacteristic;
}
