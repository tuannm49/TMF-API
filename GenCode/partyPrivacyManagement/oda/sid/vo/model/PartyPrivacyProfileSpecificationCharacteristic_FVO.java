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
import oda.sid.vo.model.CharacteristicSpecification_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyPrivacyProfileSpecificationCharacteristic_FVO extends CharacteristicSpecification_FVO implements java.io.Serializable {
    private String privacyUsagePurpose;
    @OneToMany
    @JoinColumn(name = "PartyPrivacyProfileSpecificationCharacteristic_FVO_id")
    @JsonManagedReference
    private List<PartyRoleSpecificationRef_FVO> allowedRole;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String name;
    private String description;
    private String criticalityLevel;
    private String privacyType;
}
