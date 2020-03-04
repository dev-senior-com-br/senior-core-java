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

}
