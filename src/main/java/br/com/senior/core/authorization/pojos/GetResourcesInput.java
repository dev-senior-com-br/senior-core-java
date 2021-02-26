package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de entrada do {@link br.com.senior.core.authorization.AuthorizationClient#getResources(GetResourcesInput) getResource}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetResourcesInput {

    /**
     * Os identificadores únicos dos recursos
     */
    List<String> uris;

}
