package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Dados para redefinição de senha
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordInfo {

    /**
     * Token temporário gerado quando o usuário precisa alterar a senha
     */
    String temporaryToken;
    /**
     * Nome do tenant
     */
    String tenant;

}
