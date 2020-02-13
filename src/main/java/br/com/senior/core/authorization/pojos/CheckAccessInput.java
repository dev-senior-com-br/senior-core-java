package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
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

    public CheckAccessInput(List<PermissionToCheck> permissions, Boolean includeFilters, Boolean includeDelegations) {
        this.permissions = permissions;
        this.includeFilters = includeFilters;
        this.includeDelegations = includeDelegations;
    }
}
