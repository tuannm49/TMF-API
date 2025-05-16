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
import oda.sid.tmf.model.others.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckPermission extends Entity implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @ManyToOne
    @JoinColumn(name = "permissionSpecification_id")
    @JsonBackReference
    private PermissionSpecificationRefOrValue permissionSpecification;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef user;
    @OneToMany
    @JoinColumn(name = "CheckPermission_id")
    @JsonManagedReference
    private List<Characteristic> characteristic;
    @OneToMany
    @JoinColumn(name = "CheckPermission_id")
    @JsonManagedReference
    private List<EntityRefOrValue> entity;
}
