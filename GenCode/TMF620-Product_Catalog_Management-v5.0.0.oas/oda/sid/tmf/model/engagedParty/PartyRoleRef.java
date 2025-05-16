package oda.sid.tmf.model.engagedParty;

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
import oda.sid.tmf.model.engagedParty.EntityRef;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyRoleRef extends EntityRef implements java.io.Serializable {
    private String partyId;
    private String partyName;
}
