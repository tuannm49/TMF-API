package oda.sid.vo.mode;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import java.util.List;
import oda.sid.vo.mode.Catalog_FVO;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductCatalog_FVO extends Catalog_FVO implements java.io.Serializable {
    @OneToMany
    @JoinColumn(name = "ProductCatalog_FVO_id")
    @JsonManagedReference
    private List<CategoryRef_FVO> category;
}
