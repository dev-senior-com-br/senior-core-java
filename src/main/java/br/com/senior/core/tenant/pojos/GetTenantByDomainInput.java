package br.com.senior.core.tenant.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.tenant.TenantClient#getTenantByDomain(GetTenantByDomainInput)}  getTenantByDomain}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetTenantByDomainInput {
    /**
     * O domínio do tenant a ter os dados retornados
     */
    @NonNull
    String tenantDomain;
}
