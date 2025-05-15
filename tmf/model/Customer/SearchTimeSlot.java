package com.example.Customer;

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
public class SearchTimeSlot implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "relatedPlace_id")
    @JsonBackReference
    private RelatedPlaceRefOrValue relatedPlace;
    private String searchResult;
    @JsonProperty("@type")
    private String type;
    @OneToMany
    @JoinColumn(name = "SearchTimeSlot_id")
    @JsonManagedReference
    private List<RelatedEntity> relatedEntity;
    private OffsetDateTime searchDate;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private RelatedParty relatedParty;
    @OneToMany
    @JoinColumn(name = "SearchTimeSlot_id")
    @JsonManagedReference
    private List<TimeSlot> availableTimeSlot;
    @JsonProperty("@baseType")
    private String baseType;
    @Id
    private String id;
    private String href;
    @OneToMany
    @JoinColumn(name = "SearchTimeSlot_id")
    @JsonManagedReference
    private List<TimeSlot> requestedTimeSlot;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonBackReference
    private SearchTimeSlotStateType status;
}
