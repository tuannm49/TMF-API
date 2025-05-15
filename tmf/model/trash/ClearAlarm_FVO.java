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
public class ClearAlarm_FVO implements java.io.Serializable {
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime alarmClearedTime;
    @JsonProperty("@type")
    private String type;
    private String clearUserId;
    @OneToMany
    @JoinColumn(name = "ClearAlarm_FVO_id")
    @JsonManagedReference
    private List<AlarmRefOrValue> alarmPattern;
    @OneToMany
    @JoinColumn(name = "ClearAlarm_FVO_id")
    @JsonManagedReference
    private List<AlarmRefOrValue> clearedAlarm;
    private String href;
    @Id
    private String id;
    private String state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private String clearSystemId;
}
