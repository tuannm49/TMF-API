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
import oda.sid.tmf.model.customer.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentMethod extends Entity implements java.io.Serializable {
    private OffsetDateTime statusDate;
    @ManyToOne
    @JoinColumn(name = "relatedPlace_id")
    @JsonBackReference
    private RelatedPlace relatedPlace;
    private String statusReason;
    private String authorizationCode;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String description;
    private Boolean isPreferred;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private RelatedParty relatedParty;
    @OneToMany
    @JoinColumn(name = "PaymentMethod_id")
    @JsonManagedReference
    private List<AccountRef> account;
    private String status;
}
