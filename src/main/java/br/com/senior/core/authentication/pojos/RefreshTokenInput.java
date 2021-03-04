package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.authentication.AuthenticationClient#refreshToken(RefreshTokenInput, String) refreshToken}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefreshTokenInput {

    /**
     * O refresh_token que foi enviado junto com o access_token no login.
     */
    String refreshToken;

    /**
     * Escopo do token. Pode ser um dos seguintes valores: phone, desktop, tablet, iot ou wearable. Se não fornecido, o valor padrão é desktop
     */
    String scope;

}