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
public class ProductOfferingTermOrCondition implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRef product;
    @ManyToOne
    @JoinColumn(name = "productOfferingTermOrConditionSpecRef_id")
    @JsonBackReference
    private ProductOfferingTermOrConditionSpecRef productOfferingTermOrConditionSpecRef;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ProductOfferingTermOrCondition_id")
    @JsonManagedReference
    private List<DataExportCountry> dataExportTransitCountry;
    private String dataProcessingDuration;
    @ManyToOne
    @JoinColumn(name = "productOfferingTermOrConditionApproval_id")
    @JsonBackReference
    private ProductOfferingTermOrConditionApproval productOfferingTermOrConditionApproval;
    private String dataProcessingFrequency;
    @OneToMany
    @JoinColumn(name = "ProductOfferingTermOrCondition_id")
    @JsonManagedReference
    private List<DataExportCountry> dataExportStorageCountry;
    private String purposeReason;
    private String dataProcessingOperation;
    @JsonProperty("@baseType")
    private String baseType;
    private String applicationLegalBasisForInputData;
    private String name;
    private String dataProcessingContext;
    @ManyToOne
    @JoinColumn(name = "userConsentScreenshot_id")
    @JsonBackReference
    private SimpleAttachment userConsentScreenshot;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
