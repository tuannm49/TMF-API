package oda.sid.vo.model;

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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DigitalIdentity_Create implements java.io.Serializable {
    private OffsetDateTime creationDate;
    private OffsetDateTime lastUpdate;
    private String nickname;
    @OneToMany
    @JoinColumn(name = "DigitalIdentity_Create_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @OneToMany
    @JoinColumn(name = "DigitalIdentity_Create_id")
    @JsonManagedReference
    private List<DigitalIdentityContactMedium> contactMedium;
    @OneToMany
    @JoinColumn(name = "DigitalIdentity_Create_id")
    @JsonManagedReference
    private List<Credential> credential;
    @ManyToOne
    @JoinColumn(name = "individualIdentified_id")
    @JsonBackReference
    private PartyRef individualIdentified;
    @OneToMany
    @JoinColumn(name = "DigitalIdentity_Create_id")
    @JsonManagedReference
    private List<RelatedParty> partyRoleIdentified;
    @OneToMany
    @JoinColumn(name = "DigitalIdentity_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "resourceIdentified_id")
    @JsonBackReference
    private ResourceRef resourceIdentified;
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
