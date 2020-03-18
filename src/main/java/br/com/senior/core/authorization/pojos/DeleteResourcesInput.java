package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.authorization.AuthorizationClient#deleteResources(DeleteResourcesInput) deleteResources}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class DeleteResourcesInput {

    /**
     * Identificadores dos recursos
     */
    List<String> resources;

}
