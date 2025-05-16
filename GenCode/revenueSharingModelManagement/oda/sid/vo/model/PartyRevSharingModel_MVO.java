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
public class PartyRevSharingModel_MVO extends Entity_MVO implements java.io.Serializable {
    private String name;
    @OneToMany
    @JoinColumn(name = "PartyRevSharingModel_MVO_id")
    @JsonManagedReference
    private List<PartyRevSharingModelItem_MVO> partyRevSharingModelItem;
    private String description;
    @OneToMany
    @JoinColumn(name = "PartyRevSharingModel_MVO_id")
    @JsonManagedReference
    private List<ProductSpecificationRef_MVO> productSpecification;
    @OneToMany
    @JoinColumn(name = "PartyRevSharingModel_MVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_MVO> relatedParty;
}
