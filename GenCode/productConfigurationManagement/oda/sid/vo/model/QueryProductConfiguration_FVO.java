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
import oda.sid.vo.model.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryProductConfiguration_FVO extends Entity implements java.io.Serializable {
    private Boolean instantSync;
    @ManyToOne
    @JoinColumn(name = "contextEntity_id")
    @JsonBackReference
    private EntityRef_FVO contextEntity;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    @JsonBackReference
    private ChannelRef_FVO channel;
    @OneToMany
    @JoinColumn(name = "QueryProductConfiguration_FVO_id")
    @JsonManagedReference
    private List<QueryProductConfigurationItem_FVO> computedProductConfigurationItem;
    @OneToMany
    @JoinColumn(name = "QueryProductConfiguration_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> contextCharacteristic;
    @OneToMany
    @JoinColumn(name = "QueryProductConfiguration_FVO_id")
    @JsonManagedReference
    private List<QueryProductConfigurationItem_FVO> requestProductConfigurationItem;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @OneToMany
    @JoinColumn(name = "QueryProductConfiguration_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
}
