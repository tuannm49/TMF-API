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
import oda.sid.vo.model.Entity_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceQualification_FVO extends Entity_FVO implements java.io.Serializable {
    private OffsetDateTime expectedQualificationDate;
    private Boolean instantSyncQualification;
    private OffsetDateTime effectiveQualificationDate;
    @OneToMany
    @JoinColumn(name = "ServiceQualification_FVO_id")
    @JsonManagedReference
    private List<ErrorMessage_FVO> errorMessage;
    private String description;
    @OneToMany
    @JoinColumn(name = "ServiceQualification_FVO_id")
    @JsonManagedReference
    private List<ExternalIdentifier_FVO> externalIdentifier;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @OneToMany
    @JoinColumn(name = "ServiceQualification_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
    private OffsetDateTime estimatedResponseDate;
    private OffsetDateTime expirationDate;
}
