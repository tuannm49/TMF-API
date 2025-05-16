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
import oda.sid.vo.model.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionSet_FVO extends Entity implements java.io.Serializable {
    private String description;
    @ManyToOne
    @JoinColumn(name = "permissionSetSpecification_id")
    @JsonBackReference
    private PermissionSpecificationSetRef_FVO permissionSetSpecification;
    @OneToMany
    @JoinColumn(name = "PermissionSet_FVO_id")
    @JsonManagedReference
    private List<Permission_FVO> permission;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_FVO user;
    @ManyToOne
    @JoinColumn(name = "granter_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_FVO granter;
}
