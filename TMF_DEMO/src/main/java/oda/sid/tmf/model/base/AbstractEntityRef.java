package oda.sid.tmf.model.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

/**
 *
 * @author bahman.barzideh
 *
 */
@MappedSuperclass
@Data
public abstract class AbstractEntityRef implements Serializable {
//    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
    @JsonProperty("@referredType")
    private String referredType;
    private String name;
    private String href;
    private String version;
    public AbstractEntityRef() {
    }

    public abstract void fetchEntity(Class theClass, int depth);

}
