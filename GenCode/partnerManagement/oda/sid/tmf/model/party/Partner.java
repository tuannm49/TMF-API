package oda.sid.tmf.model.party;

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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Partner implements java.io.Serializable {
    @Id
    private String id;
    private String href;
    private String name;
    private String status;
    private String statusReason;
    @OneToMany
    @JoinColumn(name = "Partner_id")
    @JsonManagedReference
    private List<AccountRef> account;
    @OneToMany
    @JoinColumn(name = "Partner_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    @OneToMany
    @JoinColumn(name = "Partner_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @OneToMany
    @JoinColumn(name = "Partner_id")
    @JsonManagedReference
    private List<ContactMedium> contactMedium;
    @OneToMany
    @JoinColumn(name = "Partner_id")
    @JsonManagedReference
    private List<CreditProfile> creditProfile;
    @ManyToOne
    @JoinColumn(name = "engagedParty_id")
    @JsonBackReference
    private RelatedParty engagedParty;
    @OneToMany
    @JoinColumn(name = "Partner_id")
    @JsonManagedReference
    private List<PaymentMethodRef> paymentMethod;
    @OneToMany
    @JoinColumn(name = "Partner_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
