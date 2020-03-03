package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefreshTokenInternalOutput {

    /**
     * String contendo um json com os tokens de acesso, de refresh, o tempo de validade restante para o token de acesso e o nome do usuário
     */
    String jsonToken;

    public RefreshTokenInternalOutput() {
    }

    public RefreshTokenInternalOutput(String jsonToken) {
        this.jsonToken = jsonToken;
    }

}
