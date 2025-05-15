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
public class PartyRevSharingModelItemInvolvement_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "PartyRevSharingModelItemInvolvement_FVO_id")
    @JsonManagedReference
    private List<PartyRevSharingModelInvolPrice_FVO> offeringPrice;
    @JsonProperty("@baseType")
    private String baseType;
    @OneToMany
    @JoinColumn(name = "PartyRevSharingModelItemInvolvement_FVO_id")
    @JsonManagedReference
    private List<ProductOfferingRef_FVO> productOffering;
    @JsonProperty("@type")
    private String type;
    private String name;
    private String description;
    @Id
    private String id;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @OneToMany
    @JoinColumn(name = "PartyRevSharingModelItemInvolvement_FVO_id")
    @JsonManagedReference
    private List<AgreementItemRef_FVO> agreementItem;
}
