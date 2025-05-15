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
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role_Create implements java.io.Serializable {
    private String name;
    @ManyToOne
    @JoinColumn(name = "assignedApplication_id")
    @JsonBackReference
    private ApplicationRef assignedApplication;
    @OneToMany
    @JoinColumn(name = "Role_Create_id")
    @JsonManagedReference
    private List<GroupRef> groups;
    private String roleType;
    @OneToMany
    @JoinColumn(name = "Role_Create_id")
    @JsonManagedReference
    private List<UserRef> users;
    @OneToMany
    @JoinColumn(name = "Role_Create_id")
    @JsonManagedReference
    private List<ApiResourceRef> apiResources;
}
