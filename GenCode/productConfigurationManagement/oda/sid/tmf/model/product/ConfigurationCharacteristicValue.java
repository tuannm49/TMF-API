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
import oda.sid.tmf.model.product.Extensible;

@Entity
@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigurationCharacteristicValue extends Extensible implements java.io.Serializable {
    private String rangeInterval;
    private String regex;
    private Integer valueTo;
    private String unitOfMeasure;
    private Boolean isSelected;
    private Boolean isSelectable;
    @ManyToOne
    @JoinColumn(name = "characteristicValue_id")
    @JsonBackReference
    private Characteristic characteristicValue;
    private Integer valueFrom;
}
