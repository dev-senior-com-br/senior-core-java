package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginWithKeyOutput {

    /**
     * String contendo um json com o token de acesso e tempo de validade do token de acesso
     */
    String jsonToken;

    public LoginWithKeyOutput() {
    }

    public LoginWithKeyOutput(String jsonToken) {
        this.jsonToken = jsonToken;
    }

}
