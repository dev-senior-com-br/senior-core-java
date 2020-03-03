package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RefreshTokenOutput {

    /**
     * Tipo do Scope
     */
    String scope;

    /**
     * Duração do token gerado
     */
    long expires_in;

    /**
     * Nome do usuário dono do token
     */
    String username;

    /**
     * Tipo to token
     */
    String token_type;

    /**
     * Token de acesso
     */
    String access_token;

    /**
     * Token para geração de novo token de acesso
     */
    String refresh_token;

}
