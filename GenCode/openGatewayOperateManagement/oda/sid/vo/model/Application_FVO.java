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
import java.util.List;
import oda.sid.vo.model.LogicalResource_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Application_FVO extends LogicalResource_FVO implements java.io.Serializable {
    private List<String> redirectUrl;
    @OneToMany
    @JoinColumn(name = "Application_FVO_id")
    @JsonManagedReference
    private List<ContactMedium_FVO> privacyRightsRequestContact;
    @ManyToOne
    @JoinColumn(name = "applicationOwner_id")
    @JsonBackReference
    private PartyRoleRef_FVO applicationOwner;
    private String jwksUri;
    private String category;
    private String privacyPolicyURL;
    private String logoUrl;
    @ManyToOne
    @JoinColumn(name = "digitalIdentity_id")
    @JsonBackReference
    private ApiDigitalIdentity_FVO digitalIdentity;
    private String commercialName;
}
