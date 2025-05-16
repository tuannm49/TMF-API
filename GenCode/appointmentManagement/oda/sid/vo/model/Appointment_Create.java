package oda.sid.vo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Appointment_Create implements java.io.Serializable {
    private String category;
    private String description;
    private String externalId;
    @OneToMany
    @JoinColumn(name = "Appointment_Create_id")
    @JsonManagedReference
    private List<AttachmentRefOrValue> attachment;
    @ManyToOne
    @JoinColumn(name = "calendarEvent_id")
    @JsonBackReference
    private CalendarEventRef calendarEvent;
    @OneToMany
    @JoinColumn(name = "Appointment_Create_id")
    @JsonManagedReference
    private List<ContactMedium> contactMedium;
    @OneToMany
    @JoinColumn(name = "Appointment_Create_id")
    @JsonManagedReference
    private List<Note> note;
    @OneToMany
    @JoinColumn(name = "Appointment_Create_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    @OneToMany
    @JoinColumn(name = "Appointment_Create_id")
    @JsonManagedReference
    private List<RelatedParty> relatedParty;
    @ManyToOne
    @JoinColumn(name = "relatedPlace_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue relatedPlace;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
