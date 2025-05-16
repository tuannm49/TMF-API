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

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BooleanArrayCharacteristicValueSpecification_FVO implements java.io.Serializable {
    private String rangeInterval;
    private Boolean isDefault;
    private Integer valueTo;
    private String regex;
    @JsonProperty("@baseType")
    private String baseType;
    private String unitOfMeasure;
    @ManyToOne
    @JoinColumn(name = "validFor_id")
    @JsonBackReference
    private TimePeriod validFor;
    @JsonProperty("@type")
    private String type;
    private String valueType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    private List<Boolean> value;
    private Integer valueFrom;
}
