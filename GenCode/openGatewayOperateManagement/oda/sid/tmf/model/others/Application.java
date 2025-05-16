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
import java.util.List;
import oda.sid.tmf.model.others.LogicalResource;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Application extends LogicalResource implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "approvalStatus_id")
    @JsonBackReference
    private ApprovalStatusType approvalStatus;
    private List<String> redirectUrl;
    @ManyToOne
    @JoinColumn(name = "applicationOwner_id")
    @JsonBackReference
    private PartyRoleRef applicationOwner;
    private String jwksUri;
    private String privacyPolicyURL;
    private String logoUrl;
    private String approvalStatusReason;
    @ManyToOne
    @JoinColumn(name = "digitalIdentity_id")
    @JsonBackReference
    private ApiDigitalIdentity digitalIdentity;
    @ManyToOne
    @JoinColumn(name = "channelPartner_id")
    @JsonBackReference
    private PartyRoleRef channelPartner;
    @OneToMany
    @JoinColumn(name = "Application_id")
    @JsonManagedReference
    private List<LogicalResourceRole> apiConsumerRole;
    @OneToMany
    @JoinColumn(name = "Application_id")
    @JsonManagedReference
    private List<ContactMedium> privacyRightsRequestContact;
    private String category;
    private String commercialName;
}
