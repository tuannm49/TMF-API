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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role_Update implements java.io.Serializable {
    private String name;
    private String roleType;
    @ManyToOne
    @JoinColumn(name = "assignedApplication_id")
    @JsonBackReference
    private ApplicationRef assignedApplication;
    @OneToMany
    @JoinColumn(name = "Role_Update_id")
    @JsonManagedReference
    private List<ApiResourceRef> apiResources;
    @OneToMany
    @JoinColumn(name = "Role_Update_id")
    @JsonManagedReference
    private List<UserRef> users;
    @OneToMany
    @JoinColumn(name = "Role_Update_id")
    @JsonManagedReference
    private List<GroupRef> groups;
}
