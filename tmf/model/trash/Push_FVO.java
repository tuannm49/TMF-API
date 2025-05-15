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
public class Push_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Push_FVO_id")
    @JsonManagedReference
    private List<ErrorMessage_FVO> errorMessage;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "Push_FVO_id")
    @JsonManagedReference
    private List<ResourceRef_FVO> pushedResource;
    @JsonProperty("@type")
    private String type;
}
