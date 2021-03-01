package br.com.senior.core.tenant.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.tenant.TenantClient#getTenantByDomain(GetTenantByDomainInput) (GetTenantByDomainInput) input} e
 * do {@link br.com.senior.core.tenant.TenantClient#getTenantByName(GetTenantByNameInput)} (GetTenantByNameInput) input}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class TenantOutput {

    /**
     * Dados do tenant
     */
    Tenant tenant;

}