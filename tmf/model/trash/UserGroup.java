package com.example.trash;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGroup implements java.io.Serializable {
    private OffsetDateTime createdDate;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "UserGroup_id")
    @JsonManagedReference
    private List<RoleRef> roles;
    private String name;
    @Id
    private String id;
    private String href;
    private OffsetDateTime updatedDate;
    @OneToMany
    @JoinColumn(name = "UserGroup_id")
    @JsonManagedReference
    private List<UserRef> users;
}
