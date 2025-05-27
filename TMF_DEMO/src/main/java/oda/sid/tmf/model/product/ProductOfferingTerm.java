package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import oda.sid.tmf.model.base.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductOfferingTerm extends Extensible implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;    @Embedded
    private Duration duration;
    private String name;
    private String description;
    @Embedded
    private TimePeriod validFor;
}
