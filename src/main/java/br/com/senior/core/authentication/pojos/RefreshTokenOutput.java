package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefreshTokenOutput {

    /**
     * String contendo um json com os tokens de acesso, de refresh, o tempo de validade restante para o token de acesso e o nome do usuário
     */
    String jsonToken;

    public RefreshTokenOutput() {
    }

    public RefreshTokenOutput(String jsonToken) {
        this.jsonToken = jsonToken;
    }

}
