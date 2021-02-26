package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.authorization.AuthorizationClient#getRole(GetRoleInput) getRole}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetRoleInput {

    /**
     * O nome do papel
     */
    String name;

}
