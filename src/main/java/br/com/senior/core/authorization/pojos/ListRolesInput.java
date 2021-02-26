package br.com.senior.core.authorization.pojos;

import br.com.senior.core.user.pojos.Pagination;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ListRolesInput {

    /**
     * O valor a ser pesquisado no nome dos papéis
     */
    String searchValue;
    /**
     * As configurações de paginação da listagem. Não definido, retornará os 10 primeiros resultados.
     */
    Pagination pagination;
}
