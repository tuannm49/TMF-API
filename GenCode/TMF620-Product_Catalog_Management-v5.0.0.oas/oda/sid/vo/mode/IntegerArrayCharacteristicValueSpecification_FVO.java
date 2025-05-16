package oda.sid.vo.mode;

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
import oda.sid.vo.mode.CharacteristicValueSpecification_FVO;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntegerArrayCharacteristicValueSpecification_FVO extends CharacteristicValueSpecification_FVO implements java.io.Serializable {
    private List<Integer> value;
}
