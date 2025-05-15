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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tenant implements java.io.Serializable {
    private String orgUUID;
    private String tenantUUID;
    private OffsetDateTime createdDate;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    private String domainName;
    @Id
    private String id;
    private String href;
    private Boolean isActive;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "userConfig_id")
    @JsonBackReference
    private Userinfo userConfig;
    private String email;
}
