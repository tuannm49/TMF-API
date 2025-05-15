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
public class TrackingRecord_FVO implements java.io.Serializable {
    private String systemId;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    private String description;
    private OffsetDateTime time;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String user;
    @OneToMany
    @JoinColumn(name = "TrackingRecord_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> characteristic;
}
