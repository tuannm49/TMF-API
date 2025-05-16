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
import oda.sid.tmf.model.customer.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer360TroubleTicketVO extends Entity implements java.io.Serializable {
    private String severity;
    private String statusChangeReason;
    private String description;
    private String ticketType;
    private OffsetDateTime creationDate;
    private String priority;
    private OffsetDateTime statusChangeDate;
    private OffsetDateTime expectedResolutionDate;
    private OffsetDateTime lastUpdate;
    private String name;
    private String externalIdentifier;
    private OffsetDateTime requestedResolutionDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private TroubleTicketStatusType status;
}
