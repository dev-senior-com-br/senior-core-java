package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

/**
 * Dados de paginação de uma lista
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pagination {

    /**
     * O número da página retornado. A primeira página corresponde ao índice 0
     */
    int pageNumber = 0;
    /**
     * Quantidade de registros por página
     */
    int pageSize = 10;

}
