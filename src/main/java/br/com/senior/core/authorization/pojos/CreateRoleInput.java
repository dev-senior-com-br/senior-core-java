package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.authorization.AuthorizationClient#createRole(CreateRoleInput) createRole}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateRoleInput {

    /**
     * O nome do papel
     */
    String name;
    /**
     * A descrição do papel
     */
    String description;

}
