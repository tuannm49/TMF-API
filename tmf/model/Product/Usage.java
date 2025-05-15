package com.example.Product;

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
public class Usage implements java.io.Serializable {
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany
    @JoinColumn(name = "Usage_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @OneToMany
    @JoinColumn(name = "Usage_id")
    @JsonManagedReference
    private List<RatedProductUsage> ratedProductUsage;
    private OffsetDateTime usageDate;
    @ManyToOne
    @JoinColumn(name = "usageSpecification_id")
    @JsonBackReference
    private UsageSpecificationRef usageSpecification;
    @JsonProperty("@baseType")
    private String baseType;
    @Id
    private String id;
    private String href;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Usage_id")
    @JsonManagedReference
    private List<UsageCharacteristic> usageCharacteristic;
    private String usageType;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private UsageStatusType status;
}
