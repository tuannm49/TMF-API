package vnpt.oda.tmf638.dto;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ServiceDTO {
    private String id;
    private String href;
    private String category;
    private String description;
    private LocalDateTime endDate;
    private Boolean hasStarted;
    private Boolean isBundle;
    private Boolean isServiceEnabled;
    private Boolean isStateful;
    private String name;
    private String operatingStatus;
    private LocalDateTime serviceDate;
    private String serviceType;
    private LocalDateTime startDate;
    private String startMode;
    private String state;
    private String baseType;
    private String schemaLocation;
    private String type;
    private List<AttachmentDTO> attachments;
    private List<ServiceCharacteristicDTO> serviceCharacteristics;
    private List<ExternalIdentifierDTO> externalIdentifiers;
    private List<FeatureDTO> features;
    private List<RelatedPlaceDTO> relatedPlaces;
    private List<RelatedPartyDTO> relatedParties;
    private List<ServiceRelationshipDTO> serviceRelationships;
    private List<SupportingServiceDTO> supportingServices;
    private List<SupportingResourceDTO> supportingResources;
    private List<NoteDTO> notes;
    private List<ServiceOrderItemDTO> serviceOrderItems;
    private List<IntentDTO> intents;
}
