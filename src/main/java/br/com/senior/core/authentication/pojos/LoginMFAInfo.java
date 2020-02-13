package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginMFAInfo {

    /**
     * Token temporário gerado quando o usuário possui autenticação multifator habilitada.
     */
    String temporaryToken;
    /**
     * Status da configuração da autenticação multifator por parte do usuário. Se for UNCONFIGURED ou RESETTED, deverá ser chamado a primitiva que envia um e-mail com as instruções para a configuração do MFA.
     */
    UserOTPAuthStatusDTO mfaStatus;
    /**
     * Nome do tenant
     */
    String tenant;

    public LoginMFAInfo() {
    }

    public LoginMFAInfo(String temporaryToken, UserOTPAuthStatusDTO mfaStatus, String tenant) {
        this.temporaryToken = temporaryToken;
        this.mfaStatus = mfaStatus;
        this.tenant = tenant;
    }

}
