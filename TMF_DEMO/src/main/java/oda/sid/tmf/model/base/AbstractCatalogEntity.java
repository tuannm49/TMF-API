package oda.sid.tmf.model.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import oda.sid.tmf.model.base.annotation.VersionProperty;

import java.io.Serializable;

/**
 *
 * @author bahman.barzideh
 *
 */
@MappedSuperclass
public abstract class AbstractCatalogEntity extends AbstractEntity implements Serializable {

    public final static String ROOT_CATALOG_ID = "";

    @Id
    @Column(name = "catalog_id", nullable = false)
    @JsonIgnore
    private String catalogId = "1";

    @Id
    @Column(name = "catalog_version", nullable = false)
    @JsonIgnore
    @VersionProperty
    private String catalogVersion = "1.0";

    @Transient
    @JsonIgnore
    private ParsedVersion parsedCatalogVersion;

    public AbstractCatalogEntity() {
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogVersion() {
        return catalogVersion;
    }

    public void setCatalogVersion(String catalogVersion) {
        loadCatalogVersions(catalogVersion);
    }

    public ParsedVersion getParsedCatalogVersion() {
        if (parsedCatalogVersion == null && catalogVersion != null) {
            setCatalogVersion(catalogVersion);
        }

        return parsedCatalogVersion;
    }

    public void setParsedCatalogVersion(ParsedVersion parsedCatalogVersion) {
        this.parsedCatalogVersion = parsedCatalogVersion;
        this.catalogVersion = (this.parsedCatalogVersion != null) ? this.parsedCatalogVersion.getInternalView() : null;
    }

    @Override
    public int hashCode() {
        int hash = 3;

        hash = 53 * hash + super.hashCode();

        hash = 31 * hash + (this.catalogId != null ? this.catalogId.hashCode() : 0);
        hash = 31 * hash + (this.catalogVersion != null ? this.catalogVersion.hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass() || super.equals(object) == false) {
            return false;
        }

        final AbstractCatalogEntity other = (AbstractCatalogEntity) object;
        if (Utilities.areEqual(this.catalogId, other.catalogId) == false) {
            return false;
        }

        if (Utilities.areEqual(this.catalogVersion, other.catalogVersion) == false) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "AbstractCatalogEntity{" + "catalogId=" + catalogId + ", catalogVersion=" + catalogVersion + ", parsedCatalogVersion=" + parsedCatalogVersion + '}';
    }


    private void loadCatalogVersions(String catalogVersion) {
        if (ParsedVersion.ROOT_CATALOG_VERSION.getInternalView().equals(catalogVersion) == true) {
            this.parsedCatalogVersion = ParsedVersion.ROOT_CATALOG_VERSION;
            this.catalogVersion = this.parsedCatalogVersion.getInternalView();
            return;
        }

        if (catalogVersion == null) {
            this.parsedCatalogVersion = null;
            this.catalogVersion = null;
            return;
        }

        this.parsedCatalogVersion = new ParsedVersion(catalogVersion);
        this.catalogVersion = this.parsedCatalogVersion.getInternalView();
    }

}
