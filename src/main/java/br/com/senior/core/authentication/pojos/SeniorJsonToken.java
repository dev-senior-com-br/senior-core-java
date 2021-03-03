package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import com.google.gson.annotations.SerializedName;

/**
 * Dados da autenticação
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeniorJsonToken {
    /**
     * Tipo to token
     */
    @SerializedName("token_type")
    String tokenType;
    /**
     * Token de acesso
     */
    @SerializedName("access_token")
    String accessToken;
    /**
     * Token para geração de novo token de acesso
     */
    @SerializedName("refresh_token")
    String refreshToken;
    /**
     * Duração do token gerado
     */
    @SerializedName("expires_in")
    long expiresIn;
    /**
     * Nome do usuário dono do token
     */
    String username;

    public String getAccessToken() {
        return access_token;
    }
}
