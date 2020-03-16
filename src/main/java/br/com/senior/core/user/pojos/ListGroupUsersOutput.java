package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.user.UserClient#listGroupUsers(ListGroupUsersInput) listGroupUsers}
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ListGroupUsersOutput {

    /**
     * Lista de usuários
     */
    public java.util.List<GroupBasicUser> users;
    /**
     * Informações sobre os resultados da listagem
     */
    public ListInformation listInformation;

}
