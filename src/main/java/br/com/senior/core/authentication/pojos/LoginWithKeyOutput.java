package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.authentication.AuthenticationClient#loginWithKey(LoginWithKeyInput) loginWithKey}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class LoginWithKeyOutput {

    /**
     * Contém os tokens de acesso, de refresh, o tempo de validade restante para o token de acesso e o nome do usuário.
     * Se o usuário/tenant estiver configurado para usar autenticação multifator, esse token não será retornado. Ao invés disso, será retornado um token temporário, dentro do 'mfaInfo', que
     * deverá ser enviado na primitiva loginMFA.
     */
    SeniorJsonToken jsonToken;

}
