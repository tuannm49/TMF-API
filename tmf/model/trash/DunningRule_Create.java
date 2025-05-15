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
public class DunningRule_Create implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String dunningEvent;
    @OneToMany
    @JoinColumn(name = "DunningRule_Create_id")
    @JsonManagedReference
    private List<Characteristic> dunningRuleCharacteristic;
    private String dunningAction;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String dunningCondition;
}
