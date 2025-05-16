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
import oda.sid.vo.model.Entity_MVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyRevSharingModelItem_MVO extends Entity_MVO implements java.io.Serializable {
    private String name;
    private String description;
    @OneToMany
    @JoinColumn(name = "PartyRevSharingModelItem_MVO_id")
    @JsonManagedReference
    private List<AgreementRef_MVO> agreement;
    @ManyToOne
    @JoinColumn(name = "relatedParty_id")
    @JsonBackReference
    private RelatedPartyRefOrPartyRoleRef_MVO relatedParty;
    @ManyToOne
    @JoinColumn(name = "partyAccount_id")
    @JsonBackReference
    private PartyAccountRef_MVO partyAccount;
    @OneToMany
    @JoinColumn(name = "PartyRevSharingModelItem_MVO_id")
    @JsonManagedReference
    private List<PartyRevSharingModelItemInvolvement_MVO> sharingModelItemInvolvement;
}
