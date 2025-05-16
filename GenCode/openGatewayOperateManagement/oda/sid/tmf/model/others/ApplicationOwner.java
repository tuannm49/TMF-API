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
import oda.sid.tmf.model.others.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationOwner extends Entity implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "approvalStatus_id")
    @JsonBackReference
    private ApprovalStatusType approvalStatus;
    @ManyToOne
    @JoinColumn(name = "channelPartner_id")
    @JsonBackReference
    private PartyRoleRef channelPartner;
    private String statusReason;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "engagedParty_id")
    @JsonBackReference
    private ApplicationOwnerOrganization engagedParty;
    private String approvalStatusReason;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private ApplicationOwnerStatusType status;
}
