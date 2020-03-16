package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Informações sobre as listagens
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ListInformation {

    /**
     * Quantidade total de resultados encontrados
     */
    public Long totalElements;
    /**
     * Quantidade total de páginas encontradas
     */
    public Long totalPages;

}
