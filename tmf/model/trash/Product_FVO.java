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
public class Product_FVO implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef_FVO productSpecification;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "Product_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> productCharacteristic;
    private String description;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef_FVO billingAccount;
    @OneToMany
    @JoinColumn(name = "Product_FVO_id")
    @JsonManagedReference
    private List<RelatedOrderItem_FVO> productOrderItem;
    @OneToMany
    @JoinColumn(name = "Product_FVO_id")
    @JsonManagedReference
    private List<ServiceRef_FVO> realizingService;
    private OffsetDateTime terminationDate;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "Product_FVO_id")
    @JsonManagedReference
    private List<ResourceRef_FVO> realizingResource;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "Product_FVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue_FVO> place;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Product_FVO_id")
    @JsonManagedReference
    private List<AgreementItemRef_FVO> agreementItem;
    @OneToMany
    @JoinColumn(name = "Product_FVO_id")
    @JsonManagedReference
    private List<ProductRefOrValue_FVO> product;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef_FVO productOffering;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "Product_FVO_id")
    @JsonManagedReference
    private List<ProductTerm_FVO> productTerm;
    @OneToMany
    @JoinColumn(name = "Product_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_FVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "intent_id")
    @JsonBackReference
    private IntentRefOrValue_FVO intent;
    private String productSerialNumber;
    private String name;
    @OneToMany
    @JoinColumn(name = "Product_FVO_id")
    @JsonManagedReference
    private List<ProductRelationship_FVO> productRelationship;
    private Boolean isCustomerVisible;
    private OffsetDateTime orderDate;
    @OneToMany
    @JoinColumn(name = "Product_FVO_id")
    @JsonManagedReference
    private List<ProductPrice_FVO> productPrice;
    private OffsetDateTime startDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private ProductStatusType status;
}
