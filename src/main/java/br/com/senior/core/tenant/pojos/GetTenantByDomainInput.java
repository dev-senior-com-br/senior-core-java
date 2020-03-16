package br.com.senior.core.tenant.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetTenantByDomainInput {
    @NonNull
    String tenantDomain;
}