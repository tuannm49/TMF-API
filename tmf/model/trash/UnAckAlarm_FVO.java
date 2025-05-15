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
public class UnAckAlarm_FVO implements java.io.Serializable {
    private OffsetDateTime ackTime;
    private String ackUserId;
    @OneToMany
    @JoinColumn(name = "UnAckAlarm_FVO_id")
    @JsonManagedReference
    private List<AlarmRefOrValue> unAckedAlarm;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "UnAckAlarm_FVO_id")
    @JsonManagedReference
    private List<AlarmRefOrValue> alarmPattern;
    private String ackSystemId;
    private String href;
    @Id
    private String id;
    private String state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
