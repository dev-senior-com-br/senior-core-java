package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de saída do {@link br.com.senior.core.user.UserClient#listGroupUsers(ListGroupUsersInput) listGroupUsers}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ListGroupUsersOutput {

    /**
     * Lista de usuários
     */
    List<GroupBasicUser> users;
    /**
     * Informações sobre os resultados da listagem
     */
    ListInformation listInformation;

}
