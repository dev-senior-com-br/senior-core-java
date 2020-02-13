package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetRoleOutput {

    /**
     * O papel com o nome informado
     */
    Role role;

    public GetRoleOutput() {
    }

    public GetRoleOutput(Role role) {
        this.role = role;
    }

}
