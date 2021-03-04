package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.authorization.AuthorizationClient#deleteRole(DeleteRoleInput) deleteRole}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeleteRoleInput {

    /**
     * Nome do papel a ser deletado
     */
    String name;

}
