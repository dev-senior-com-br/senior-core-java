package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Conjunto de chave do filtro e seus valores
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleServiceFilterSet {

    /**
     * Chave de domínio, serviço e sequencial
     */
    RoleServiceFilterKey key;
    /**
     * Campo obrigatório se for uma inclusão
     */
    List<RoleServiceFilter> filters;

}
