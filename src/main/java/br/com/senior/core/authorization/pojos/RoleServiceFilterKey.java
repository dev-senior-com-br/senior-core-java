package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Chave do filtro de serviço no papel
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleServiceFilterKey {

    /**
     * Domínio do filtro
     */
    String domainName;
    /**
     * Serviço do filtro
     */
    String serviceName;
    /**
     * Sequência para agrupamento do conjunto de filtros
     */
    Long sequence;

}
