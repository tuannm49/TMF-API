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

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedPartyRefOrPartyRoleRef_MVO_allOf implements java.io.Serializable {
    @ManyToOne
    @JoinColumn(name = "partyOrPartyRole_id")
    @JsonBackReference
    private PartyRefOrPartyRoleRef_MVO partyOrPartyRole;
    private String role;
}
