package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de entrada do {@link br.com.senior.core.authorization.AuthorizationClient#unassignUsers(UnassignUsersInput) unassignUsers}
 */
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
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
