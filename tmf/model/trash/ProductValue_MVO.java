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
public class ProductValue_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef_MVO productSpecification;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "ProductValue_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> productCharacteristic;
    private String description;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef_MVO billingAccount;
    @OneToMany
    @JoinColumn(name = "ProductValue_MVO_id")
    @JsonManagedReference
    private List<RelatedOrderItem_MVO> productOrderItem;
    @OneToMany
    @JoinColumn(name = "ProductValue_MVO_id")
    @JsonManagedReference
    private List<ServiceRef_MVO> realizingService;
    private OffsetDateTime terminationDate;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "ProductValue_MVO_id")
    @JsonManagedReference
    private List<ResourceRef_MVO> realizingResource;
    private String href;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "ProductValue_MVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue_MVO> place;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "ProductValue_MVO_id")
    @JsonManagedReference
    private List<AgreementItemRef_MVO> agreementItem;
    @OneToMany
    @JoinColumn(name = "ProductValue_MVO_id")
    @JsonManagedReference
    private List<ProductRefOrValue_MVO> product;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef_MVO productOffering;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "ProductValue_MVO_id")
    @JsonManagedReference
    private List<ProductTerm_MVO> productTerm;
    @OneToMany
    @JoinColumn(name = "ProductValue_MVO_id")
    @JsonManagedReference
    private List<RelatedParty_MVO> relatedParty;
    private String productSerialNumber;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductValue_MVO_id")
    @JsonManagedReference
    private List<ProductRelationship_MVO> productRelationship;
    private Boolean isCustomerVisible;
    private OffsetDateTime orderDate;
    @OneToMany
    @JoinColumn(name = "ProductValue_MVO_id")
    @JsonManagedReference
    private List<ProductPrice_MVO> productPrice;
    private OffsetDateTime startDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private ProductStatusType status;
}
