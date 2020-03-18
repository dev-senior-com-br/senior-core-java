package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Payload de entrada do {@link br.com.senior.core.authorization.AuthorizationClient#getAssignedUsers(GetAssignedUsersInput) getAssignedUsers}
 */
@AllArgsConstructor
@NoArgsConstructor
public class GetAssignedUsersInput {

    /**
     * Nomes dos papéis onde os usuários estão atribuídos
     */
    public List<String> roles;

}
