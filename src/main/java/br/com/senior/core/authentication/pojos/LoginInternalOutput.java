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
public class LoginInternalOutput {

    /**
     * String contendo um json com os tokens de acesso, de refresh, o tempo de validade restante para o token de acesso e o nome do usuário.
     * Se o usuário/tenant estiver configurado para usar autenticação multifator, esse token não será retornado. Ao invés disso, será retornado um token temporário, dentro do 'mfaInfo', que
     * deverá ser enviado na primitiva loginMFA.
     */
    String jsonToken;
    /**
     * Informações para realizar o próximo passo da autenticação quando o usuário utiliza autenticação multifator.
     */
    LoginMFAInfo mfaInfo;
    /**
     * Informações para realizar o próximo passo da autenticação quando o usuário está sinalizado para alterar a senha após se autenticar.
     */
    ResetPasswordInfo resetPasswordInfo;

}
