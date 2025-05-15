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
public class PartyRevSharingModelItem_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PartyRevSharingModelItem_FVO_id")
    @JsonManagedReference
    private List<AgreementRef_FVO> agreement;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "partyAccount_id")
    @JsonBackReference
    private PartyAccountRef_FVO partyAccount;
    @OneToMany
    @JoinColumn(name = "PartyRevSharingModelItem_FVO_id")
    @JsonManagedReference
    private List<PartyRevSharingModelItemInvolvement_FVO> sharingModelItemInvolvement;
    private String name;
    private String description;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_FVO relatedParty;
}
