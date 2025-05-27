package oda.sid.tmf.model.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.logging.Logger;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductCatalog extends Catalog implements java.io.Serializable {
    private final static long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Catalog.class.getName());
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "ProdCat_category")
    private List<CategoryRef> category;
}
