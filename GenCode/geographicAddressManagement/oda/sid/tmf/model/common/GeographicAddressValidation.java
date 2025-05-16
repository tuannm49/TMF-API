package oda.sid.tmf.model.common;

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
import oda.sid.tmf.model.common.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicAddressValidation extends Entity implements java.io.Serializable {
    private String validationResult;
    @OneToMany
    @JoinColumn(name = "GeographicAddressValidation_id")
    @JsonManagedReference
    private List<AlternateGeographicAddressValidation> alternateGeographicAddress;
    @ManyToOne
    @JoinColumn(name = "validGeographicAddress_id")
    @JsonBackReference
    private GeographicAddress validGeographicAddress;
    private Boolean provideAlternative;
    @ManyToOne
    @JoinColumn(name = "submittedGeographicAddress_id")
    @JsonBackReference
    private GeographicAddress submittedGeographicAddress;
    private String href;
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    private OffsetDateTime validationDate;
}
