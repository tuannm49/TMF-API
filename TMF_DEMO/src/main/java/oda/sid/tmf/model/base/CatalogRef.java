package oda.sid.tmf.model.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import oda.sid.tmf.model.base.annotation.VersionProperty;
import oda.sid.tmf.model.client.CatalogClient;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import java.io.Serializable;
/**
 *
 * @author bahman.barzideh
 *
 * The prefix 'ref' was added to the property names of this class to work
 * around an issue in the platform.  Without the prefix, you could not update the
 * id & version fields of entity properties that were of this class.  For example,
 * attempting to update or edit the ResourceCandidate.category[n].version would
 * throw an exception.  The exception would claim the operation was attempting to
 * update a key field (the real key field is named ENTITY_VERSION in the database).
 * The 'ref' prefix fixes this issue while making this class a bit uglier
 * than it needs to be.
 *
 */

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Embeddable
public class CatalogRef extends AbstractEntityRef implements Serializable {
    public final static long serialVersionUID = 1L;

    @Column(name = "REF_ID", nullable = true)
    @JsonProperty(value = "id")
    private String refId;

    @Column(name = "REF_VERSION", nullable = true)
    @JsonProperty(value = "version")
    @VersionProperty
    private String refVersion;

    @Transient
    @JsonIgnore
    private ParsedVersion parsedVersion;

    @Column(name = "REF_HREF", nullable = true)
    @JsonProperty(value = "href")
    private String refHref;

    @Column(name = "REF_NAME", nullable = true)
    @JsonProperty(value = "name")
    private String refName;

    @Column(name = "REF_DESCRIPTION", nullable = true)
    @JsonProperty(value = "description")
    private String refDescription;

    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@type")
    private String type;
    @Transient
    @JsonUnwrapped
    private AbstractEntity entity;

    public CatalogRef() {
        entity = null;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getRefVersion() {
        return refVersion;
    }

    public void setRefVersion(String refVersion) {
        if (refVersion == null) {
            this.refVersion = null;
            this.parsedVersion = null;
            return;
        }

        this.parsedVersion = new ParsedVersion(refVersion);
        this.refVersion = this.parsedVersion.getInternalView();
    }

    public ParsedVersion getParsedVersion() {
        if (parsedVersion == null && refVersion != null) {
            parsedVersion = new ParsedVersion(refVersion);
        }

        return parsedVersion;
    }

    public String getRefHref() {
        return refHref;
    }

    public void setRefHref(String refHref) {
        this.refHref = refHref;
    }

    public String getRefName() {
        return refName;
    }

    public void setRefName(String refName) {
        this.refName = refName;
    }

    public String getRefDescription() {
        return refDescription;
    }

    public void setRefDescription(String refDescription) {
        this.refDescription = refDescription;
    }

    public AbstractEntity getEntity() {
        return entity;
    }

    public void setEntity(AbstractEntity entity) {
        this.entity = entity;
    }

    @JsonProperty(value = "id")
    public String idToJson() {
        return (entity == null) ? refId : null;
    }

    @JsonProperty(value = "version")
    public String versionToJson() {
        if (entity != null) {
            return null;
        }

        ParsedVersion theParsedVersion = getParsedVersion();
        return (theParsedVersion != null) ? theParsedVersion.getExternalView() : null;
    }

    @JsonProperty(value = "href")
    public String hrefToJson() {
        return (entity == null) ? refHref : null;
    }

    @JsonProperty(value = "name")
    public String nameToJson() {
        return (entity == null) ? refName : null;
    }

    @JsonProperty(value = "description")
    public String descriptionToJson() {
        return (entity == null) ? refDescription : null;
    }

    @Override
    public int hashCode() {
        int hash = 5;

        hash = 53 * hash + (this.refId != null ? this.refId.hashCode() : 0);
        hash = 53 * hash + (this.refVersion != null ? this.refVersion.hashCode() : 0);
        hash = 53 * hash + (this.refHref != null ? this.refHref.hashCode() : 0);
        hash = 53 * hash + (this.refName != null ? this.refName.hashCode() : 0);
        hash = 53 * hash + (this.refDescription != null ? this.refDescription.hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final CatalogRef other = (CatalogRef) object;
        if (Utilities.areEqual(this.refId, other.refId) == false) {
            return false;
        }

        if (Utilities.areEqual(this.refVersion, other.refVersion) == false) {
            return false;
        }

        if (Utilities.areEqual(this.refHref, other.refHref) == false) {
            return false;
        }

        if (Utilities.areEqual(this.refName, other.refName) == false) {
            return false;
        }

        if (Utilities.areEqual(this.refDescription, other.refDescription) == false) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Reference{" + "refId=" + refId + ", refVersion=" + refVersion + ", parsedVersion=" + parsedVersion + ", refHref=" + refHref + ", refName=" + refName + ", refDescription=" + refDescription + ", entity=" + entity + '}';
    }

    @Override
    public void fetchEntity(Class theClass, int depth) {
        entity = (AbstractEntity) CatalogClient.getObject(refHref, theClass, depth);
    }

    public static CatalogRef createProto() {
        CatalogRef catalogReference = new CatalogRef ();

        catalogReference.refId = "id";
        catalogReference.refVersion = "1.6";
        catalogReference.refHref = "href";
        catalogReference.refName = "name";
        catalogReference.refDescription = "description";
        catalogReference.entity = null;

        return catalogReference;
    }

}
