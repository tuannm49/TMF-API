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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Promotion_MVO implements java.io.Serializable {
    private String description;
    private OffsetDateTime lastUpdate;
    private String lifecycleStatus;
    @OneToMany
    @JoinColumn(name = "Promotion_MVO_id")
    @JsonManagedReference
    private List<PromotionPattern_MVO> pattern;
    private String type;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    private String name;
}
