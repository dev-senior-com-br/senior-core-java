package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResetPasswordInfo {

    /**
     * Token temporário gerado quando o usuário precisa alterar a senha
     */
    String temporaryToken;
    /**
     * Nome do tenant
     */
    String tenant;

    public ResetPasswordInfo() {
    }

    public ResetPasswordInfo(String temporaryToken, String tenant) {
        this.temporaryToken = temporaryToken;
        this.tenant = tenant;
    }
}
