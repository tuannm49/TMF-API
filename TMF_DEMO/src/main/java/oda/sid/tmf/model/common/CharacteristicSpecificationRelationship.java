package oda.sid.tmf.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import oda.sid.tmf.model.base.*;
import oda.sid.tmf.model.product.Catalog;
import org.hibernate.annotations.GenericGenerator;

import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacteristicSpecificationRelationship extends Extensible implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;    private String name;
    private String characteristicSpecificationId;
    private String relationshipType;
    private String parentSpecificationHref;
    @Embedded
    private TimePeriod validFor;
    private String parentSpecificationId;
}
