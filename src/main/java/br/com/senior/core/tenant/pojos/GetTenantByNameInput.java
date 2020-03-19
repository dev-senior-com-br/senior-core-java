package br.com.senior.core.tenant.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.tenant.TenantClient#getTenantByName(String) getTenantByName}
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetTenantByNameInput {
    /**
     * O nome do tenant a ter os dados retornados
     */
    @NonNull
    String tenantName;
}
