package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
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

    public UnassignUsersInput() {
    }

    public UnassignUsersInput(List<String> roles, List<String> users) {
        this.roles = roles;
        this.users = users;
    }

}
