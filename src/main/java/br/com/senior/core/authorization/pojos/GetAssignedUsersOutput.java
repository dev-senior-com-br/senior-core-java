package br.com.senior.core.authorization.pojos;

import java.util.List;

public class GetAssignedUsersOutput {

    /**
     * Usuários vinculados
     */
    public List<String> users;

    public GetAssignedUsersOutput() {
    }

    public GetAssignedUsersOutput(List<String> users) {
        this.users = users;
    }

}
