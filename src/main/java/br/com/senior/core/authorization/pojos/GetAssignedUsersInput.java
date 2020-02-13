package br.com.senior.core.authorization.pojos;

import java.util.List;

public class GetAssignedUsersInput {

    /**
     * Nomes dos papéis onde os usuários estão atribuídos
     */
    public List<String> roles;

    public GetAssignedUsersInput() {
    }

    public GetAssignedUsersInput(List<String> roles) {
        this.roles = roles;
    }

}
