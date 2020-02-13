package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
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

    public AssignUsersInput() {
    }

    public AssignUsersInput(List<String> roles, List<String> users) {
        this.roles = roles;
        this.users = users;
    }

}
