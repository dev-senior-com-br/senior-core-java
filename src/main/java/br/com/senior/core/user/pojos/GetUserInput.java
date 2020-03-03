package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetUserInput {

    /**
     * "Nome do usuário no formato nome@dominio_tenant"
     */
    String username;

    public GetUserInput() {
    }

    public GetUserInput(String username) {
        this.username = username;
    }

}
