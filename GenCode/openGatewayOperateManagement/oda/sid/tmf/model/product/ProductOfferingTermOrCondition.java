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
import java.util.List;
import oda.sid.tmf.model.product.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOfferingTermOrCondition extends Extensible implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private ProductRef product;
    @ManyToOne
    @JoinColumn(name = "productOfferingTermOrConditionSpecRef_id")
    @JsonBackReference
    private ProductOfferingTermOrConditionSpecRef productOfferingTermOrConditionSpecRef;
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
    private String applicationLegalBasisForInputData;
    private String name;
    private String dataProcessingContext;
    @ManyToOne
    @JoinColumn(name = "userConsentScreenshot_id")
    @JsonBackReference
    private SimpleAttachment userConsentScreenshot;
    private String id;
}
