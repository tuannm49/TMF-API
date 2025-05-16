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
import oda.sid.vo.model.LogicalResource_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Application_MVO extends LogicalResource_MVO implements java.io.Serializable {
    private List<String> redirectUrl;
    @OneToMany
    @JoinColumn(name = "Application_MVO_id")
    @JsonManagedReference
    private List<ContactMedium_MVO> privacyRightsRequestContact;
    private String jwksUri;
    private String category;
    private String privacyPolicyURL;
    private String logoUrl;
    private String approvalStatusReason;
    @ManyToOne
    @JoinColumn(name = "digitalIdentity_id")
    @JsonBackReference
    private ApiDigitalIdentity_MVO digitalIdentity;
    private String commercialName;
}
