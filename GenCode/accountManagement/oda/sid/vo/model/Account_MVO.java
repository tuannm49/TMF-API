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
import java.time.OffsetDateTime;
import java.util.List;
import oda.sid.vo.model.Entity_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account_MVO extends Entity_MVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "Account_MVO_id")
    @JsonManagedReference
    private List<TaxExemptionCertificate_MVO> taxExemption;
    private OffsetDateTime lastUpdate;
    private String accountType;
    @OneToMany
    @JoinColumn(name = "Account_MVO_id")
    @JsonManagedReference
    private List<Contact_MVO> contact;
    private String name;
    @ManyToOne
    @JoinColumn(name = "creditLimit_id")
    @JsonBackReference
    private Money creditLimit;
    private String description;
    @OneToMany
    @JoinColumn(name = "Account_MVO_id")
    @JsonManagedReference
    private List<AccountRelationship_MVO> accountRelationship;
    private String state;
    @OneToMany
    @JoinColumn(name = "Account_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
    @OneToMany
    @JoinColumn(name = "Account_MVO_id")
    @JsonManagedReference
    private List<AccountBalance_MVO> accountBalance;
}
