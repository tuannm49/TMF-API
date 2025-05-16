package oda.sid.tmf.model.product;

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
import oda.sid.tmf.model.product.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiProductOrder extends Entity implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ApiProductOrder_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    @ManyToOne
    @JoinColumn(name = "channelPartner_id")
    @JsonBackReference
    private PartyRoleRef channelPartner;
    private String description;
    @OneToMany
    @JoinColumn(name = "ApiProductOrder_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalId;
    private OffsetDateTime expectedCompletionDate;
    private OffsetDateTime completionDate;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ProductOrderStateType state;
    @OneToMany
    @JoinColumn(name = "ApiProductOrder_id")
    @JsonManagedReference
    private List<DCSProductOrderItem> productOrderItem;
    private OffsetDateTime creationDate;
}
