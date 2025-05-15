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
public class PolicyVariableDynamic_FVO_FVO implements java.io.Serializable {
    private String format;
    @OneToMany
    @JoinColumn(name = "PolicyVariableDynamic_FVO_FVO_id")
    @JsonManagedReference
    private List<PolicyVariableResolver_FVO> resolver;
    @JsonProperty("@type")
    private String type;
    private String valueType;
}
