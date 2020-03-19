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
     * String contendo um json com o token de acesso e tempo de validade do token de acesso
     */
    String jsonToken;

}
