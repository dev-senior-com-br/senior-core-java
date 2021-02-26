package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de entrada do {@link br.com.senior.core.authorization.AuthorizationClient#checkAccess(CheckAccessInput) checkAccess}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckAccessInput {

    /**
     * As permissões à serem verificadas
     */
    List<PermissionToCheck> permissions;
    /**
     * Retornar os filtros de serviço e recurso associados se possuir permissão no recurso
     */
    Boolean includeFilters = false;
    /**
     * Retornar as delegações associadas se possuir permissão no recurso
     */
    Boolean includeDelegations = false;

}
