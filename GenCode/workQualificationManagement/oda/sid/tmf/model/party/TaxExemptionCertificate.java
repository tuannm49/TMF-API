package oda.sid.tmf.model.party;

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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaxExemptionCertificate implements java.io.Serializable {
    @Id
    private String id;
    private String certificateNumber;
    private String issuingJurisdiction;
    private String reason;
    @ManyToOne
    @JoinColumn(name = "attachment_id")
    @JsonBackReference
    private AttachmentRefOrValue attachment;
    @OneToMany
    @JoinColumn(name = "TaxExemptionCertificate_id")
    @JsonManagedReference
    private List<TaxDefinition> taxDefinition;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
