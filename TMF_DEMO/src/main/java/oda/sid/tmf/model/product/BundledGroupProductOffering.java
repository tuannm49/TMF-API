package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import oda.sid.tmf.model.base.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BundledGroupProductOffering extends Extensible implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    private String name;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "BndlGroupProdOffr")
    private List<BundledGroupProductOffering> bundledGroupProductOffering;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "BndlGroupProdOffr")
    private List<BundledProductOffering> bundledProductOffering;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private BundledGroupProductOfferingOption bundledGroupProductOfferingOption;
}
