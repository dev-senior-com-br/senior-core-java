package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Payload de saída do {@link br.com.senior.core.authorization.AuthorizationClient#getAssignedUsers(GetAssignedUsersInput) getAssignedUsers}
 */
@AllArgsConstructor
@NoArgsConstructor
public class GetAssignedUsersOutput {

    /**
     * Usuários vinculados
     */
    public List<String> users;

}
