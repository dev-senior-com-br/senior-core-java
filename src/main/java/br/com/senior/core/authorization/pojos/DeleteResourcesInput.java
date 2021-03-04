package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de entrada do {@link br.com.senior.core.authorization.AuthorizationClient#deleteResources(DeleteResourcesInput) deleteResources}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeleteResourcesInput {

    /**
     * Identificadores dos recursos
     */
    List<String> resources;

}
