package br.com.senior.core.configuration.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    private String ownerDomain;
    private String ownerService;
    private String propertyTenant;
    private String propertyDomain;
    private String propertyService;
    private String propertyKey;
    private PropertyType propertyType;
    private String propertyValue;
    private PropertyScope propertyScope;
    private Boolean propertyMaster;
    private java.util.List<String> propertyHashTags;
    private String propertyLabel;
    private String propertySource;
    private PropertyLevel propertyLevel;

    /**
     * This convenience constructor allows initialization of all required fields.
     */
    public Property(String ownerDomain, String ownerService) {
        this.ownerDomain = ownerDomain;
        this.ownerService = ownerService;
    }

}
