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
import oda.sid.tmf.model.others.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Activity extends Entity implements java.io.Serializable {
    private String plannedCost;
    private OffsetDateTime creationdate;
    @ManyToOne
    @JoinColumn(name = "activityRelationship_id")
    @JsonBackReference
    private EntitySpecificationRef activityRelationship;
    private OffsetDateTime validfor;
    private OffsetDateTime plannedEnd;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private PartyOrPartyRole relatedParty;
    private OffsetDateTime plannedStart;
    @ManyToOne
    @JoinColumn(name = "plannedTenure_id")
    @JsonBackReference
    private TimePeriod plannedTenure;
    private String actualCost;
}
