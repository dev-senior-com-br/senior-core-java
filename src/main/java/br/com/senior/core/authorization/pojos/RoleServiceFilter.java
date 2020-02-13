package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Chave e valor do filtro de serviço no papel
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleServiceFilter {

    /**
     * Identificador único do filtro dentro do domínio/serviço
     */
    String name;
    /**
     * Valor do filtro
     */
    String value;

}
