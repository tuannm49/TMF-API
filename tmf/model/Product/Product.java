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
public class Product implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef productSpecification;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "Product_id")
    @JsonManagedReference
    private List<Characteristic> productCharacteristic;
    private String description;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef billingAccount;
    @OneToMany
    @JoinColumn(name = "Product_id")
    @JsonManagedReference
    private List<RelatedOrderItem> productOrderItem;
    @OneToMany
    @JoinColumn(name = "Product_id")
    @JsonManagedReference
    private List<ServiceRef> realizingService;
    private OffsetDateTime terminationDate;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "Product_id")
    @JsonManagedReference
    private List<ResourceRef> realizingResource;
    private String href;
    @Id
    private String id;
    @OneToMany
    @JoinColumn(name = "Product_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue> place;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Product_id")
    @JsonManagedReference
    private List<AgreementItemRef> agreementItem;
    @OneToMany
    @JoinColumn(name = "Product_id")
    @JsonManagedReference
    private List<ProductRefOrValue> product;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef productOffering;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "Product_id")
    @JsonManagedReference
    private List<ProductTerm> productTerm;
    @OneToMany
    @JoinColumn(name = "Product_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> relatedParty;
    @ManyToOne
    @JoinColumn(name = "intent_id")
    @JsonBackReference
    private IntentRefOrValue intent;
    private String productSerialNumber;
    private String name;
    @OneToMany
    @JoinColumn(name = "Product_id")
    @JsonManagedReference
    private List<ProductRelationship> productRelationship;
    private Boolean isCustomerVisible;
    private OffsetDateTime orderDate;
    @OneToMany
    @JoinColumn(name = "Product_id")
    @JsonManagedReference
    private List<ProductPrice> productPrice;
    private OffsetDateTime startDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private ProductStatusType status;
}
