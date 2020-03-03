package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class GetAssignedUsersOutput {

    /**
     * Usuários vinculados
     */
    public List<String> users;

}
