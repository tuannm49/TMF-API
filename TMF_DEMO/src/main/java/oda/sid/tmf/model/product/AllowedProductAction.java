package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import oda.sid.tmf.model.base.*;
import oda.sid.tmf.model.common.ChannelRef;
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
    private String id;    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "AllowedProdAction_channel")
    private List<ChannelRef> channel;
    @Embedded
    private TimePeriod validFor;
    private String action;
}
