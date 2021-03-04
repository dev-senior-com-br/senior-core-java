package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.user.UserClient#listGroups(ListGroupsInput) listGroups}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ListGroupsInput {

    /**
     * O valor a ser pesquisado no nome do grupo
     */
    public String searchValue;
    /**
     * Tenant que deseja buscar os grupos, apenas permitido para master
     */
    public String tenant;
    /**
     * As configurações de paginação da listagem. Não definido, retornará os 10 primeiros resultados.
     */
    public Pagination pagination;

}
