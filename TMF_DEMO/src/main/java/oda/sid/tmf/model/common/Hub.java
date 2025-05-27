package oda.sid.tmf.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import lombok.Data;
import oda.sid.tmf.model.base.*;
import oda.sid.tmf.model.product.Catalog;

import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hub extends AbstractEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    private String callback;
    private String query;
}
