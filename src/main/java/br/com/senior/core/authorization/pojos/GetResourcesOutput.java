package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.authorization.AuthorizationClient#getResources(GetResourcesInput) getResource}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetResourcesOutput {

    /**
     * Os recursos das URIs informadas
     */
    List<Resource> resources;

}
