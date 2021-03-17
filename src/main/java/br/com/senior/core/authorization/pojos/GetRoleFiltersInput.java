package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetRoleFiltersInput {

    /**
     * Lista com o nome dos papéis
     */
    List<String> roles;

    /**
     * Nome do domínio onde os filtros estão vinculados
     */
    String domainName;

    /**
     * Nome do serviço onde os filtros estão vinculados
     */
    String serviceName;
}
