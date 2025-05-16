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
import oda.sid.tmf.model.product.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductValue extends Extensible implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef productSpecification;
    @OneToMany
    @JoinColumn(name = "ProductValue_id")
    @JsonManagedReference
    private List<Characteristic> productCharacteristic;
    private String description;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef billingAccount;
    @OneToMany
    @JoinColumn(name = "ProductValue_id")
    @JsonManagedReference
    private List<RelatedOrderItem> productOrderItem;
    @OneToMany
    @JoinColumn(name = "ProductValue_id")
    @JsonManagedReference
    private List<ServiceRef> realizingService;
    private OffsetDateTime terminationDate;
    @OneToMany
    @JoinColumn(name = "ProductValue_id")
    @JsonManagedReference
    private List<ResourceRef> realizingResource;
    private String href;
    private String id;
    @OneToMany
    @JoinColumn(name = "ProductValue_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue> place;
    @OneToMany
    @JoinColumn(name = "ProductValue_id")
    @JsonManagedReference
    private List<AgreementItemRef> agreementItem;
    @OneToMany
    @JoinColumn(name = "ProductValue_id")
    @JsonManagedReference
    private List<ProductRefOrValue> product;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef productOffering;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "ProductValue_id")
    @JsonManagedReference
    private List<ProductTerm> productTerm;
    @OneToMany
    @JoinColumn(name = "ProductValue_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    private String productSerialNumber;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductValue_id")
    @JsonManagedReference
    private List<ProductRelationship> productRelationship;
    private Boolean isCustomerVisible;
    private OffsetDateTime orderDate;
    @OneToMany
    @JoinColumn(name = "ProductValue_id")
    @JsonManagedReference
    private List<ProductPrice> productPrice;
    private OffsetDateTime startDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private ProductStatusType status;
}
