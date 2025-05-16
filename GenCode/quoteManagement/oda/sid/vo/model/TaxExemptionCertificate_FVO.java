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
import java.util.List;
import oda.sid.vo.model.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaxExemptionCertificate_FVO extends Extensible implements java.io.Serializable {
    private String reason;
    @OneToMany
    @JoinColumn(name = "TaxExemptionCertificate_FVO_id")
    @JsonManagedReference
    private List<TaxDefinition> taxDefinition;
    @ManyToOne
    @JoinColumn(name = "attachment_id")
    @JsonBackReference
    private AttachmentRefOrValue_FVO attachment;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String certificateNumber;
    private String id;
    private String issuingJurisdiction;
}
