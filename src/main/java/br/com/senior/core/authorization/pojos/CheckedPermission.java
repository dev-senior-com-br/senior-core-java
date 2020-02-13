package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Resultado da verificação de permissão
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckedPermission {

    /**
     * URI do recurso
     */
    String resource;
    /**
     * Ação do recurso
     */
    String action;
    /**
     * Se o usuário possui permissão
     */
    Boolean authorized;
    /**
     * Identifica se a permissão foi dada por ser proprietário
     */
    Boolean owner = false;
    /**
     * Os filtros de serviço existentes para o domínio e serviço do recurso (somente se houver permissão)
     */
    List<RoleServiceFilterSet> serviceFilters;
    /**
     * Os filtros existentes do recurso (somente se houver permissão)
     */
    List<String> resourceFilters;
    /**
     * As delegações que referenciam esse recurso (somente se houver permissão)
     */
    List<Delegation> delegations;

}
