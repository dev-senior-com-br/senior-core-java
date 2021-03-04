package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de entrada do {@link br.com.senior.core.authorization.AuthorizationClient#unassignUsers(UnassignUsersInput) unassignUsers}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UnassignUsersInput {

    /**
     * Nomes dos papéis onde os usuários serão removidos
     */
    List<String> roles;
    /**
     * Os usuário à serem removidos dos papéis
     */
    List<String> users;

}
