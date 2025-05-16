package oda.sid.tmf.model.common;

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
import java.util.List;
import oda.sid.tmf.model.common.Extensible;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Characteristic extends Extensible implements java.io.Serializable {
    private String name;
    private String id;
    @OneToMany
    @JoinColumn(name = "Characteristic_id")
    @JsonManagedReference
    private List<CharacteristicRelationship> characteristicRelationship;
    private String valueType;
}
