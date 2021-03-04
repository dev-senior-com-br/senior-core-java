package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de saída do {@link br.com.senior.core.authorization.AuthorizationClient#getResources(GetResourcesInput) getResource}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class GetResourcesOutput {

    /**
     * Os recursos das URIs informadas
     */
    List<Resource> resources;

}
