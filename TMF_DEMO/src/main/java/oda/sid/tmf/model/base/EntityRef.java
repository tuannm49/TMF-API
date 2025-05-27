package oda.sid.tmf.model.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import lombok.Data;
import oda.sid.tmf.model.client.EntityClient;

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
@MappedSuperclass
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Data
public class EntityRef extends AbstractEntityRef implements Serializable {
    public final static long serialVersionUID = 1L;

    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @JsonProperty(value = "id")
    private String refId;

    @JsonProperty(value = "href")
    private String refHref;

    @JsonProperty(value = "name")
    private String refName;

    @JsonProperty(value = "description")
    private String refDescription;

    @JsonProperty("@type")
    private String type;
    @JsonProperty("@baseType")
    private String baseType;
    @JsonProperty("@schemaLocation")
    private String schemaLocation;
    @JsonProperty("@referredType")
    private String referredType;
    @Transient
    @JsonUnwrapped
    private AbstractEntity entity;

    @Override
    public void fetchEntity(Class theClass, int depth) {
        entity = (AbstractEntity) EntityClient.getObject(refHref, theClass, depth);
    }

}
