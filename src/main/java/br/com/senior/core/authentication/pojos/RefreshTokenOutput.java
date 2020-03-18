package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.authentication.AuthenticationClient#refreshToken(RefreshTokenInput, String) refreshToken}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenOutput {

    /**
     * Dados de Autenticação
     */
    SeniorJsonToken jsonToken;

}
