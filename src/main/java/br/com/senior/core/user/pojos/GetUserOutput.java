package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetUserOutput {

    /**
     * Tenant name do usuário
     */
    String tenantName;

    public GetUserOutput() {
    }

    public GetUserOutput(String tenantName) {
        this.tenantName = tenantName;
    }

}
