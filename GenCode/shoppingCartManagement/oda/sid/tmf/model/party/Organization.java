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
import oda.sid.tmf.model.party.Party;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Organization extends Party implements java.io.Serializable {
    private String organizationType;
    private String nameType;
    private String tradingName;
    @ManyToOne
    @JoinColumn(name = "existsDuring_id")
    @JsonBackReference
    private TimePeriod existsDuring;
    @OneToMany
    @JoinColumn(name = "Organization_id")
    @JsonManagedReference
    private List<OrganizationChildRelationship> organizationChildRelationship;
    private Boolean isHeadOffice;
    private String name;
    private Boolean isLegalEntity;
    @OneToMany
    @JoinColumn(name = "Organization_id")
    @JsonManagedReference
    private List<OtherNameOrganization> otherName;
    @OneToMany
    @JoinColumn(name = "Organization_id")
    @JsonManagedReference
    private List<OrganizationIdentification> organizationIdentification;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private OrganizationStateType status;
    @ManyToOne
    @JoinColumn(name = "organizationParentRelationship_id")
    @JsonBackReference
    private OrganizationParentRelationship organizationParentRelationship;
}
