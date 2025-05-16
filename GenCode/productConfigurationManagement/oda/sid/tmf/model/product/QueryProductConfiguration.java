package oda.sid.tmf.model.product;

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
import oda.sid.tmf.model.product.Entity;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QueryProductConfiguration extends Entity implements java.io.Serializable {
    private Boolean instantSync;
    @ManyToOne
    @JoinColumn(name = "contextEntity_id")
    @JsonBackReference
    private EntityRef contextEntity;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    @JsonBackReference
    private ChannelRef channel;
    @OneToMany
    @JoinColumn(name = "QueryProductConfiguration_id")
    @JsonManagedReference
    private List<QueryProductConfigurationItem> computedProductConfigurationItem;
    @OneToMany
    @JoinColumn(name = "QueryProductConfiguration_id")
    @JsonManagedReference
    private List<Characteristic> contextCharacteristic;
    @OneToMany
    @JoinColumn(name = "QueryProductConfiguration_id")
    @JsonManagedReference
    private List<QueryProductConfigurationItem> requestProductConfigurationItem;
    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonBackReference
    private TaskStateType state;
    @OneToMany
    @JoinColumn(name = "QueryProductConfiguration_id")
    @JsonManagedReference
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
}
