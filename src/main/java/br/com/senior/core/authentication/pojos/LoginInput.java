package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.authentication.AuthenticationClient#login(LoginInput) login}
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class LoginInput {

    /**
     * Nome do usuário incluindo o domínio. Exemplo: ana.silva@senior.com.br.
     * Este campo deve ser informado se o login for baseado em um usuário e senha.
     */
    String username;
    /**
     * Senha do usuário. Este campo deve ser informado se o login for baseado em um usuário e senha.
     */
    String password;
    /**
     * Código de autorização do provedor externo de autenticação. Provedores suportados: SAML.
     * Este campo deve ser informado se o login for baseado em um código de autorização.
     */
    String code;
    /**
     * Escopo do token da autenticação. Opcional, se não for informado será usado o valor padrão 'desktop'
     */
    String scope;

    /**
     * Construtor
     *
     * @param username - Usuário
     * @param password - Senha
     */
    public LoginInput(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
