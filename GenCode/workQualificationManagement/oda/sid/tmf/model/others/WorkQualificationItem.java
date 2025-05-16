package oda.sid.tmf.model.others;

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
public class WorkQualificationItem implements java.io.Serializable {
    @Id
    private String id;
    private OffsetDateTime expectedWorkDate;
    private OffsetDateTime expirationDate;
    @OneToMany
    @JoinColumn(name = "WorkQualificationItem_id")
    @JsonManagedReference
    private List<EligibilityUnavailabilityReason> eligibilityUnavailabilityReason;
    @ManyToOne
    @JoinColumn(name = "work_id")
    @JsonBackReference
    private WorkRefOrValue work;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
