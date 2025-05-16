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
import oda.sid.vo.model.Entity_FVO;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckProductConfiguration_FVO extends Entity_FVO implements java.io.Serializable {
    private Boolean instantSync;
    @ManyToOne
    @JoinColumn(name = "contextEntity_id")
    @JsonBackReference
    private EntityRef_FVO contextEntity;
    private Boolean provideAlternatives;
    @OneToMany
    @JoinColumn(name = "CheckProductConfiguration_FVO_id")
    @JsonManagedReference
    private List<CheckProductConfigurationItem_FVO> checkProductConfigurationItem;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    @JsonBackReference
    private ChannelRef_FVO channel;
    @OneToMany
    @JoinColumn(name = "CheckProductConfiguration_FVO_id")
    @JsonManagedReference
    private List<Characteristic_FVO> contextCharacteristic;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @OneToMany
    @JoinColumn(name = "CheckProductConfiguration_FVO_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef_FVO> relatedParty;
}
