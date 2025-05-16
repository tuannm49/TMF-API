package oda.sid.tmf.model.party;

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
import oda.sid.tmf.model.party.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyRevSharingAlgorithm extends Entity implements java.io.Serializable {
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "PartyRevSharingAlgorithm_id")
    @JsonManagedReference
    private List<PartyRevSharingPolicyActionVariable> actionVariable;
    @OneToMany
    @JoinColumn(name = "PartyRevSharingAlgorithm_id")
    @JsonManagedReference
    private List<PartyRevSharingPolicyConditionVariable> conditionVariable;
    @OneToMany
    @JoinColumn(name = "PartyRevSharingAlgorithm_id")
    @JsonManagedReference
    private List<PolicyRef> policy;
}
