package oda.sid.tmf.model.customer;

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
import oda.sid.tmf.model.customer.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Authorization extends Extensible implements java.io.Serializable {
    private OffsetDateTime givenDate;
    private String name;
    @OneToMany
    @JoinColumn(name = "Authorization_id")
    @JsonManagedReference
    private List<RelatedPartyOrPartyRole> approver;
    private String signatureRepresentation;
    private OffsetDateTime requestedDate;
    private String state;
}
