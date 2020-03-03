package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
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
