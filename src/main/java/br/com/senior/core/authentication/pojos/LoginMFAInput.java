package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.authentication.AuthenticationClient#loginMFA(LoginMFAInput) loginMFA}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
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
