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
public class CommentAlarm_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "CommentAlarm_FVO_id")
    @JsonManagedReference
    private List<AlarmRefOrValue> commentedAlarm;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "CommentAlarm_FVO_id")
    @JsonManagedReference
    private List<AlarmRefOrValue> alarmPattern;
    @ManyToOne
    @JoinColumn(name = "comment_id")
    @JsonBackReference
    private Comment comment;
    private String href;
    @Id
    private String id;
    private String state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
