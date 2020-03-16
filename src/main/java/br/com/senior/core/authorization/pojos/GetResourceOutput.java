package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.authorization.AuthorizationClient#getResource(GetResourceInput) getResource}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetResourceOutput {

    /**
     * Os recursos das URIs informadas
     */
    List<Resource> resources;

}
