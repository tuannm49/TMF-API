package oda.sid.tmf.model.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

/**
 *
 * @author bahman.barzideh
 *
 * {
 *     "role": "Owner",
 *     "id": "1234",
 *     "href": "http ://serverLocation:port/partyManagement/partyRole/1234"
 * }
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Embeddable
@Entity
@Data
public class RelatedParty implements Serializable {
    private final static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String href;

    private String name;

    @Embedded
    private TimePeriod validFor;

    @JsonProperty(value = "role")
    private String partyRole;



}
