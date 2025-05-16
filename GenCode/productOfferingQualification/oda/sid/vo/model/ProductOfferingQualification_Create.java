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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOfferingQualification_Create implements java.io.Serializable {
    private Boolean instantSyncQualification;
    private String projectId;
    private Boolean provideAlternative;
    private OffsetDateTime requestedPOQCompletionDate;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualification_Create_id")
    @JsonManagedReference
    private List<ProductOfferingQualificationItem> productOfferingQualificationItem;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualification_Create_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrValue> relatedParty;
    @OneToMany
    @JoinColumn(name = "ProductOfferingQualification_Create_id")
    @JsonManagedReference
    private List<StateChange> stateChange;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
