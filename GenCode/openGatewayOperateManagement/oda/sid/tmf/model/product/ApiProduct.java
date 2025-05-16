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
import oda.sid.tmf.model.product.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiProduct extends Entity implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "productSpecification_id")
    @JsonBackReference
    private ProductSpecificationRef productSpecification;
    private String apiName;
    @ManyToOne
    @JoinColumn(name = "productOffering_id")
    @JsonBackReference
    private ProductOfferingRef productOffering;
    private String purpose;
    private String description;
    @OneToMany
    @JoinColumn(name = "ApiProduct_id")
    @JsonManagedReference
    private List<ProductOfferingTermOrCondition> approvedProductOfferingTermOrCondition;
    @OneToMany
    @JoinColumn(name = "ApiProduct_id")
    @JsonManagedReference
    private List<RelatedOrderItem> productOrderItem;
    private OffsetDateTime creationDate;
    private OffsetDateTime terminationDate;
    @OneToMany
    @JoinColumn(name = "ApiProduct_id")
    @JsonManagedReference
    private List<ApiVersionDetails> apiVersionDetails;
    @ManyToOne
    @JoinColumn(name = "channelPartner_id")
    @JsonBackReference
    private PartyRoleRef channelPartner;
    @OneToMany
    @JoinColumn(name = "ApiProduct_id")
    @JsonManagedReference
    private List<ISO31661Alpha2StandardIdentifier> countryCode;
    private String name;
    private OffsetDateTime orderDate;
    @OneToMany
    @JoinColumn(name = "ApiProduct_id")
    @JsonManagedReference
    private List<AgreementItemRef> agreementItem;
    private OffsetDateTime startDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private ProductStatusType status;
}
