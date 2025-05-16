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
import oda.sid.vo.model.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeographicSubAddressValue_MVO extends Extensible implements java.io.Serializable {
    private String buildingName;
    @OneToMany
    @JoinColumn(name = "GeographicSubAddressValue_MVO_id")
    @JsonManagedReference
    private List<GeographicSubAddressUnit_MVO> subUnit;
    private String levelType;
    private String levelNumber;
    private String name;
    private String subAddressType;
    private String privateStreetNumber;
    private String privateStreetName;
}
