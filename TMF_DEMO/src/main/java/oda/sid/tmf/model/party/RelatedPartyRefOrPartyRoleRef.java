package oda.sid.tmf.model.party;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import oda.sid.tmf.model.base.*;
import oda.sid.tmf.model.product.Catalog;

import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RelatedPartyRefOrPartyRoleRef extends EntityRef implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private PartyRefOrPartyRoleRef partyOrPartyRole;
    private String role;
}
