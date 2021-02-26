package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.authentication.AuthenticationClient#logout(LogoutInput) logout}
 */
@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogoutInput {

    /**
     * Token de acesso que será invalidado.
     */
    String accessToken;

}
