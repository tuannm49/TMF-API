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
import lombok.Data;
import oda.sid.tmf.model.product.BaseEntity;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyConditionVariable extends BaseEntity implements java.io.Serializable {
    private String fields;
    private String filter;
    private String path;
}
