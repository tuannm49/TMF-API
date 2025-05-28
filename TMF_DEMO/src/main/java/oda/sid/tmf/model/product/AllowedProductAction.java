package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import oda.sid.tmf.model.base.EntityRef;
import oda.sid.tmf.model.base.Extensible;
import oda.sid.tmf.model.base.TimePeriod;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllowedProductAction extends Extensible implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "channel_ChannelRef")
    private List<EntityRef> channel;
    @Embedded
    private TimePeriod validFor;
    private String action;
}
