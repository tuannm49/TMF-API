package oda.sid.tmf.model.service;

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
import oda.sid.tmf.model.service.ServiceQualification;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckServiceQualification extends ServiceQualification implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CheckServiceQualification_id")
    @JsonManagedReference
    private List<CheckServiceQualificationItem> serviceQualificationItem;
    private Boolean provideResultReason;
    private Boolean provideAlternative;
    private String qualificationResult;
    private OffsetDateTime checkServiceQualificationDate;
}
