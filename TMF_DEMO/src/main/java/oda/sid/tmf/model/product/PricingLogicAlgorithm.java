package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Data;
import oda.sid.tmf.model.base.*;

import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PricingLogicAlgorithm extends AbstractEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    private String description;
    private String plaSpecId;
    @Embedded
    private TimePeriod validFor;
}
