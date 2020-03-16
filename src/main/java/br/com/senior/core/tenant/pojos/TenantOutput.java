package br.com.senior.core.tenant.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.tenant.TenantClient#getTenantByDomain(String) getTenantByDomain} e
 * do {@link br.com.senior.core.tenant.TenantClient#getTenantByName(String) getTenantByName}
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TenantOutput {

    /**
     * Dados do tenant
     */
    Tenant tenant;

}