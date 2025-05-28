package oda.sid.tmf.model.common;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.util.logging.Logger;
import oda.sid.tmf.model.others.*;
import oda.sid.tmf.model.common.*;
import oda.sid.tmf.model.customer.*;
import oda.sid.tmf.model.party.*;
import oda.sid.tmf.model.product.*;
import oda.sid.tmf.model.resource.*;
import oda.sid.tmf.model.sale.*;
import oda.sid.tmf.model.service.*;
import oda.sid.tmf.model.base.*;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Event extends Extensible implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    private String eventId;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Characteristic")
    private List<Characteristic> analyticCharacteristic;
    private String description;
    @OneToOne
    private EntityRef source;
    private String eventType;
    private String title;
    private String priority;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "relatedParty_RelatedPartyRefOrPartyRoleRef")
    private List<EntityRef> relatedParty;
    private String domain;
    private Date eventTime;
    @OneToOne
    private EntityRef reportingSystem;
    private String correlationId;
    private String href;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String event;
    private Date timeOccurred;
}
