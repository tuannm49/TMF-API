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
public class Role implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "assignedApplication_id")
    @JsonBackReference
    private ApplicationRef assignedApplication;
    private OffsetDateTime createdDate;
    @OneToMany
    @JoinColumn(name = "Role_id")
    @JsonManagedReference
    private List<ApiResourceRef> apiResources;
    private String name;
    @OneToMany
    @JoinColumn(name = "Role_id")
    @JsonManagedReference
    private List<GroupRef> groups;
    @Id
    private String id;
    private OffsetDateTime updatedDate;
    private String roleType;
    @OneToMany
    @JoinColumn(name = "Role_id")
    @JsonManagedReference
    private List<UserRef> users;
}
