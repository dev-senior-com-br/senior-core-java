package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Integration {
    /**
     * Nome do usuário recebido via integração, caso não tenha um usuário informado na coluna 'integration_username' será retornado o usuário padrão
     */
    String integrationName;
    /**
     * Código do usuário, aplicado para os usuários integrados através da G5
     */
    String integrationCode;
}
