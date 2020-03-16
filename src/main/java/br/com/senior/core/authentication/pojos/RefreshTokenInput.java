package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.authentication.AuthenticationClient#refreshToken(RefreshTokenInput, String) refreshToken}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class RefreshTokenInput {

    /**
     * O refresh_token que foi enviado junto com o access_token no login.
     */
    String refreshToken;

    /**
     * Escopo do token. Pode ser um dos seguintes valores: phone, desktop, tablet, iot ou wearable. Se não fornecido, o valor padrão é desktop
     */
    String scope;

    /**
     * Construtor
     *
     * @param refreshToken
     */
    public RefreshTokenInput(String refreshToken) {
        this.refreshToken = refreshToken;
    }

}