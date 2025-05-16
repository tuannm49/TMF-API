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
import oda.sid.vo.model.Extensible_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductValue_FVO extends Extensible_FVO implements java.io.Serializable {
    private Boolean isBundle;
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef_FVO productSpecification;
    @OneToMany
    @JoinColumn(name = "ProductValue_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> productCharacteristic;
    private String description;
    @ManyToOne
    @JoinColumn(name = "billingAccount_id")
    @JsonBackReference
    private BillingAccountRef_FVO billingAccount;
    @OneToMany
    @JoinColumn(name = "ProductValue_FVO_id")
    @JsonManagedReference
    private List<RelatedOrderItem_FVO> productOrderItem;
    @OneToMany
    @JoinColumn(name = "ProductValue_FVO_id")
    @JsonManagedReference
    private List<ServiceRef_FVO> realizingService;
    private OffsetDateTime terminationDate;
    @OneToMany
    @JoinColumn(name = "ProductValue_FVO_id")
    @JsonManagedReference
    private List<ResourceRef_FVO> realizingResource;
    private String href;
    private String id;
    @OneToMany
    @JoinColumn(name = "ProductValue_FVO_id")
    @JsonManagedReference
    private List<RelatedPlaceRefOrValue_FVO> place;
    @OneToMany
    @JoinColumn(name = "ProductValue_FVO_id")
    @JsonManagedReference
    private List<AgreementItemRef_FVO> agreementItem;
    @OneToMany
    @JoinColumn(name = "ProductValue_FVO_id")
    @JsonManagedReference
    private List<ProductRefOrValue_FVO> product;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef_FVO productOffering;
    private OffsetDateTime creationDate;
    @OneToMany
    @JoinColumn(name = "ProductValue_FVO_id")
    @JsonManagedReference
    private List<ProductTerm_FVO> productTerm;
    @OneToMany
    @JoinColumn(name = "ProductValue_FVO_id")
    @JsonManagedReference
    private List<RelatedParty_FVO> relatedParty;
    private String productSerialNumber;
    private String name;
    @OneToMany
    @JoinColumn(name = "ProductValue_FVO_id")
    @JsonManagedReference
    private List<ProductRelationship_FVO> productRelationship;
    private Boolean isCustomerVisible;
    private OffsetDateTime orderDate;
    @OneToMany
    @JoinColumn(name = "ProductValue_FVO_id")
    @JsonManagedReference
    private List<ProductPrice_FVO> productPrice;
    private OffsetDateTime startDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private ProductStatusType status;
}
