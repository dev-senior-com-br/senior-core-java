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
    public int pageNumber = 0;
    /**
     * Quantidade de registros por página
     */
    public int pageSize = 10;

}
