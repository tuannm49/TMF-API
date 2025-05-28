package oda.sid.tmf.model.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import lombok.Data;
import oda.sid.tmf.model.base.AbstractEntity;
import oda.sid.tmf.model.product.Catalog;

import java.util.Date;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseEvent extends AbstractEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    private String eventId;
    private String domain;
    private Date eventTime;
    private String description;
    private String correlationId;
    private String eventType;
    private String event;
    private String title;
    private String priority;
    private Date timeOcurred;
}
