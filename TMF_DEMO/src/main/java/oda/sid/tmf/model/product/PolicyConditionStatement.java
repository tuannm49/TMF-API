package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import oda.sid.tmf.model.base.AbstractEntity;

import java.util.List;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyConditionStatement extends AbstractEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    private String description;
    private String name;
    private String opType;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "PolicyConditionValue")
    private List<PolicyConditionValue> PolicyConditionValue;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private PolicyConditionVariable PolicyConditionVariable;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
}
