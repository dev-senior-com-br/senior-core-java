package br.com.senior.core.authorization.pojos;

import br.com.senior.core.user.pojos.Pagination;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
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
