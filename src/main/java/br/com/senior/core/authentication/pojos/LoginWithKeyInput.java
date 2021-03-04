package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.authentication.AuthenticationClient#loginWithKey(LoginWithKeyInput) loginWithKey}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginWithKeyInput {

    /**
     * Chave da aplicação
     */
    String accessKey;
    /**
     * Segredo da chave informada
     */
    String secret;
    /**
     * Nome do tenant em que se deseja efetuar o login
     */
    String tenantName;
    /**
     * Escopo do token da autenticação. Opcional, se não for informado será usado o valor padrão 'desktop'
     */
    String scope;

}
