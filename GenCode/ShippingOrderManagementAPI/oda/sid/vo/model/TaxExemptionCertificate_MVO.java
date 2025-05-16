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
public class TaxExemptionCertificate_MVO extends Extensible implements java.io.Serializable {
    private String reason;
    @OneToMany
    @JoinColumn(name = "TaxExemptionCertificate_MVO_id")
    @JsonManagedReference
    private List<TaxDefinition_MVO> taxDefinition;
    @ManyToOne
    @JoinColumn(name = "attachment_id")
    @JsonBackReference
    private AttachmentRefOrValue_MVO attachment;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String certificateNumber;
    private String issuingJurisdiction;
}
