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
public class UserGroup_Create implements java.io.Serializable {
    private String name;
    @OneToMany
    @JoinColumn(name = "UserGroup_Create_id")
    @JsonManagedReference
    private List<UserRef> users;
    @OneToMany
    @JoinColumn(name = "UserGroup_Create_id")
    @JsonManagedReference
    private List<RoleRef> roles;
}
