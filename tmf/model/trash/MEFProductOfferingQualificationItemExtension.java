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
public class MEFProductOfferingQualificationItemExtension implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRefOrValue product;
    @ManyToOne
    @JoinColumn(name = "serviceabilityConfidence_id")
    @JsonBackReference
    private ServiceabilityColor serviceabilityConfidence;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "installationInterval_id")
    @JsonBackReference
    private TimePeriod installationInterval;
    @JsonProperty("@type")
    private String type;
    private OffsetDateTime guaranteedUntilDate;
    private String serviceConfidenceReason;
    @OneToMany
    @JoinColumn(name = "MEFProductOfferingQualificationItemExtension_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrValue> relatedParty;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
