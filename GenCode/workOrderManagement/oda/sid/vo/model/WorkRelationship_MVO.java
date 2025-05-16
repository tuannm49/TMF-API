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
public class WorkRelationship_MVO extends Entity implements java.io.Serializable {
    private String relationshipType;
    @ManyToOne
    @JoinColumn(name = "work_id")
    @JsonBackReference
    private WorkRefOrValue_MVO work;
    @OneToMany
    @JoinColumn(name = "WorkRelationship_MVO_id")
    @JsonManagedReference
    private List<Characteristic_MVO> workRelationshipCharacteristic;
}
