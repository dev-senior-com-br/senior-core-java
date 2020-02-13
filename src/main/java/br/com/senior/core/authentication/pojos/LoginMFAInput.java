package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginMFAInput {

    /**
     * Token temporário que foi retornado pela primitiva 'login'.
     */
    String temporaryToken;
    /**
     * Código de validação gerado pelo Google Authenticator
     */
    Long validationCode;

    public LoginMFAInput() {
    }

    public LoginMFAInput(String temporaryToken, Long validationCode) {
        this.temporaryToken = temporaryToken;
        this.validationCode = validationCode;
    }

}
