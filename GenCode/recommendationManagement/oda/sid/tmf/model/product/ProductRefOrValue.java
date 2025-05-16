package oda.sid.tmf.model.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductRefOrValue implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private String description;
    private Boolean isBundle;
    private Boolean isCustomerVisible;
    private String name;
    private OffsetDateTime orderDate;
    private String productSerialNumber;
    private OffsetDateTime startDate;
    private OffsetDateTime terminationDate;
    @OneToMany
    @JoinColumn(name = "ProductRefOrValue_id")
    @JsonManagedReference
    private List<AgreementItemRef> agreement;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef billingAccount;
    @OneToMany
    @JoinColumn(name = "ProductRefOrValue_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue> place;
    @OneToMany
    @JoinColumn(name = "ProductRefOrValue_id")
    @JsonManagedReference
    private List<ProductRefOrValue> product;
    @OneToMany
    @JoinColumn(name = "ProductRefOrValue_id")
    @JsonManagedReference
    private List<Characteristic> productCharacteristic;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef productOffering;
    @OneToMany
    @JoinColumn(name = "ProductRefOrValue_id")
    @JsonManagedReference
    private List<RelatedProductOrderItem> productOrderItem;
    @OneToMany
    @JoinColumn(name = "ProductRefOrValue_id")
    @JsonManagedReference
    private List<ProductPrice> productPrice;
    @OneToMany
    @JoinColumn(name = "ProductRefOrValue_id")
    @JsonManagedReference
    private List<ProductRelationship> productRelationship;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef productSpecification;
    @OneToMany
    @JoinColumn(name = "ProductRefOrValue_id")
    @JsonManagedReference
    private List<ProductTerm> productTerm;
    @OneToMany
    @JoinColumn(name = "ProductRefOrValue_id")
    @JsonManagedReference
    private List<ResourceRef> realizingResource;
    @OneToMany
    @JoinColumn(name = "ProductRefOrValue_id")
    @JsonManagedReference
    private List<ServiceRef> realizingService;
    @OneToMany
    @JoinColumn(name = "ProductRefOrValue_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private ProductStatusType status;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("@referredType")
    private String referredType;
}
