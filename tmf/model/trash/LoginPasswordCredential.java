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
public class LoginPasswordCredential implements java.io.Serializable {
    private String password;
    @OneToMany
    @JoinColumn(name = "LoginPasswordCredential_id")
    @JsonManagedReference
    private List<DigitalIdentityContactMedium> contactMedium;
    @JsonProperty("@baseType")
    private String baseType;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @Id
    private String id;
    private String state;
    private String trustLevel;
    private String login;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
