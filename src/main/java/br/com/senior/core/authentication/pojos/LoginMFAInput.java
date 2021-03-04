package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.authentication.AuthenticationClient#loginMFA(LoginMFAInput) loginMFA}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginMFAInput {

    /**
     * Token temporário que foi retornado pela primitiva 'login'.
     */
    String temporaryToken;
    /**
     * Código de validação gerado pelo Google Authenticator
     */
    String validationCode;

}
