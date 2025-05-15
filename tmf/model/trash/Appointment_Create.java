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
public class Appointment_Create implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "relatedPlace_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue relatedPlace;
    @OneToMany
    @JoinColumn(name = "Appointment_Create_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "Appointment_Create_id")
    @JsonManagedReference
    private List<ContactMedium> contactMedium;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "Appointment_Create_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    private String description;
    private String externalId;
    @ManyToOne
    @JoinColumn(name = "calendarEvent_id")
    @JsonBackReference
    private CalendarEventRef calendarEvent;
    @OneToMany
    @JoinColumn(name = "Appointment_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @OneToMany
    @JoinColumn(name = "Appointment_Create_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @JsonProperty("@baseType")
    private String baseType;
    private String category;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
