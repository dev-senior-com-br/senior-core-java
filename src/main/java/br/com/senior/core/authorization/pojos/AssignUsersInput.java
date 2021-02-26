package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de entrada do {@link br.com.senior.core.authorization.AuthorizationClient#assignUsers(AssignUsersInput) assignUsers}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssignUsersInput {

    /**
     * Nomes dos papéis onde os usuários serão atribuídos
     */
    List<String> roles;
    /**
     * Os usuário à serem incluídos nos papéis
     */
    List<String> users;

}
