package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class SeniorJsonRefreshToken {

    /**
     * Tipo do scopo
     */
    String scope;
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
    /**
     * Duração do token gerado
     */
    long expires_in;
    /**
     * Nome do usuário dono do token
     */
    String username;
}
