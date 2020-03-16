package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.user.UserClient#listGroupUsers(ListGroupUsersInput) listGroupUsers}
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ListGroupUsersInput {

    /**
     * Identificador do grupo.
     */
    @NonNull
    public String id;
    /**
     * Termo para buscar nos campos nome, nome completo e e-mail.
     */
    public String searchValue;
    /**
     * As configurações de paginação da listagem. Não definido, retornará os 10 primeiros resultados.
     */
    public Pagination pagination;

}
