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
public class ApiProductOrder implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ApiProductOrder_id")
    @JsonManagedReference
    private List<AgreementRef> agreement;
    @JsonProperty("@type")
    private String type;
    private String description;
    @OneToMany
    @JoinColumn(name = "ApiProductOrder_id")
    @JsonManagedReference
    private List<ExternalIdentifier> externalId;
    @OneToMany
    @JoinColumn(name = "ApiProductOrder_id")
    @JsonManagedReference
    private List<DCSProductOrderItem> productOrderItem;
    private OffsetDateTime creationDate;
    @ManyToOne
    @JoinColumn(name = "channelPartner_id")
    @JsonBackReference
    private PartyRoleRef channelPartner;
    @JsonProperty("@baseType")
    private String baseType;
    private OffsetDateTime expectedCompletionDate;
    private OffsetDateTime completionDate;
    private String href;
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private ProductOrderStateType state;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
