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
public class Usage implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private String description;
    private OffsetDateTime usageDate;
    private String usageType;
    @OneToMany
    @JoinColumn(name = "Usage_id")
    @JsonManagedReference
    private List<RatedProductUsage> ratedProductUsage;
    @OneToMany
    @JoinColumn(name = "Usage_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private UsageStatusType status;
    @OneToMany
    @JoinColumn(name = "Usage_id")
    @JsonManagedReference
    private List<UsageCharacteristic> usageCharacteristic;
    @ManyToOne
    @JoinColumn(name = "usageSpecification_id")
    @JsonBackReference
    private UsageSpecificationRef usageSpecification;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
