package br.com.senior.core.tenant.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetTenantByNameInput {
    @NonNull
    String tenantName;
}
