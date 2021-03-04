package br.com.senior.core.tenant.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.tenant.TenantClient#getTenantByDomain(String)}  getTenantByDomain}
 */
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetTenantByDomainInput {
    /**
     * O domínio do tenant a ter os dados retornados
     */
    @NonNull
    String tenantDomain;
}
