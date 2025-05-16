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
import oda.sid.vo.model.Party_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Organization_MVO extends Party_MVO implements java.io.Serializable {
    private String organizationType;
    private String nameType;
    private String tradingName;
    @ManyToOne
    @JoinColumn(name = "existsDuring_id")
    @JsonBackReference
    private TimePeriod existsDuring;
    @OneToMany
    @JoinColumn(name = "Organization_MVO_id")
    @JsonManagedReference
    private List<OrganizationChildRelationship_MVO> organizationChildRelationship;
    private Boolean isHeadOffice;
    private String name;
    private Boolean isLegalEntity;
    @OneToMany
    @JoinColumn(name = "Organization_MVO_id")
    @JsonManagedReference
    private List<OtherNameOrganization_MVO> otherName;
    @OneToMany
    @JoinColumn(name = "Organization_MVO_id")
    @JsonManagedReference
    private List<OrganizationIdentification_MVO> organizationIdentification;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private OrganizationStateType status;
    @ManyToOne
    @JoinColumn(name = "organizationParentRelationship_id")
    @JsonBackReference
    private OrganizationParentRelationship_MVO organizationParentRelationship;
}
