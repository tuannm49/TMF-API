package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import oda.sid.tmf.model.base.*;
import oda.sid.tmf.model.party.RelatedPartyRefOrPartyRoleRef;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Catalog extends AbstractEntity implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    private String catalogType;
    private String lifecycleStatus;
    @Embedded
    private TimePeriod validFor;
    private Date lastUpdate;
    private String description;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Cat_relatedPty")
    private List<RelatedPartyRefOrPartyRoleRef> relatedParty;
    private String version;
}
