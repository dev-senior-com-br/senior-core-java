package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Dados de paginação de uma lista
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pagination {

    /**
     * O número da página retornado. A primeira página corresponde ao índice 0
     */
    public Long pageNumber = 0L;
    /**
     * Quantidade de registros por página
     */
    public Long pageSize = 10L;

}
