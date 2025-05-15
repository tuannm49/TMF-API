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
public class BillStructure_FVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "format_id")
    @JsonBackReference
    private BillFormatRefOrValue_FVO format;
    @ManyToOne
    @JoinColumn(name = "cycleSpecification_id")
    @JsonBackReference
    private BillingCycleSpecificationRefOrValue_FVO cycleSpecification;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "BillStructure_FVO_id")
    @JsonManagedReference
    private List<BillPresentationMediaRefOrValue_FVO> presentationMedia;
    @JsonProperty("@type")
    private String type;
}
