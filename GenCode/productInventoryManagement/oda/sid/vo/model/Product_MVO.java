package oda.sid.vo.model;

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
import oda.sid.vo.model.Entity_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product_MVO extends Entity_MVO implements java.io.Serializable {
    private Boolean isBundle;
    @OneToMany
    @JoinColumn(name = "Product_MVO_id")
    @JsonManagedReference
    private List<ProductRefOrValue_MVO> product;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef_MVO productSpecification;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef_MVO productOffering;
    @OneToMany
    @JoinColumn(name = "Product_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> productCharacteristic;
    private String description;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef_MVO billingAccount;
    @OneToMany
    @JoinColumn(name = "Product_MVO_id")
    @JsonManagedReference
    private List<RelatedOrderItem_MVO> productOrderItem;
    @OneToMany
    @JoinColumn(name = "Product_MVO_id")
    @JsonManagedReference
    private List<ProductTerm_MVO> productTerm;
    @OneToMany
    @JoinColumn(name = "Product_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole_MVO> relatedParty;
    @ManyToOne
    @JoinColumn(name = "intent_id")
    @JsonBackReference
    private IntentRefOrValue_MVO intent;
    @OneToMany
    @JoinColumn(name = "Product_MVO_id")
    @JsonManagedReference
    private List<ServiceRef_MVO> realizingService;
    private OffsetDateTime terminationDate;
    private String productSerialNumber;
    @OneToMany
    @JoinColumn(name = "Product_MVO_id")
    @JsonManagedReference
    private List<ResourceRef_MVO> realizingResource;
    private String name;
    @OneToMany
    @JoinColumn(name = "Product_MVO_id")
    @JsonManagedReference
    private List<ProductRelationship_MVO> productRelationship;
    @OneToMany
    @JoinColumn(name = "Product_MVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue_MVO> place;
    private Boolean isCustomerVisible;
    @OneToMany
    @JoinColumn(name = "Product_MVO_id")
    @JsonManagedReference
    private List<AgreementItemRef_MVO> agreementItem;
    private OffsetDateTime orderDate;
    @OneToMany
    @JoinColumn(name = "Product_MVO_id")
    @JsonManagedReference
    private List<ProductPrice_MVO> productPrice;
    private OffsetDateTime startDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private ProductStatusType status;
}
