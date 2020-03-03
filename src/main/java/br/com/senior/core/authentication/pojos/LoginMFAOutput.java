package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class LoginMFAOutput {

    /**
     * String contendo um json com os tokens de acesso, de refresh, o nome do usuário e o tempo de validade restante para o token de acesso.
     */
    String jsonToken;
    /**
     * Informações para realizar o próximo passo da autenticação quando o usuário está sinalizado para alterar a senha após se autenticar.
     */
    ResetPasswordInfo resetPasswordInfo;

    public LoginMFAOutput(String jsonToken) {
        this.jsonToken = jsonToken;
    }

}
