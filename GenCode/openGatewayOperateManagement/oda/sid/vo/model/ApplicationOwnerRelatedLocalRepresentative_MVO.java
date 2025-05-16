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
import oda.sid.vo.model.Extensible_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationOwnerRelatedLocalRepresentative_MVO extends Extensible_MVO implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "representative_id")
    @JsonBackReference
    private ApplicationOwnerRelatedIndividual_MVO representative;
    @ManyToOne
    @JoinColumn(name = "countryCode_id")
    @JsonBackReference
    private ISO31661Alpha2StandardIdentifier_MVO countryCode;
}
