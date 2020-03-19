package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.authorization.AuthorizationClient#getResource(GetResourceInput) getResource}
 */
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetResourceInput {

    /**
     * Os identificadores únicos dos recursos
     */
    List<String> uris;

}
