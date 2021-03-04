package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de entrada do {@link br.com.senior.core.authorization.AuthorizationClient#getAssignedUsers(GetAssignedUsersInput) getAssignedUsers}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetAssignedUsersInput {

    /**
     * Nomes dos papéis onde os usuários estão atribuídos
     */
    List<String> roles;

}
