package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginWithKeyInput {

    /**
     * Chave da aplicação
     */
    String accessKey;
    /**
     * Segredo da chave informada
     */
    String secret;
    /**
     * Nome do tenant em que se deseja efetuar o login
     */
    String tenantName;
    /**
     * Escopo do token da autenticação. Opcional, se não for informado será usado o valor padrão 'desktop'
     */
    String scope;

    public LoginWithKeyInput() {
    }

    public LoginWithKeyInput(String accessKey, String secret, String tenantName, String scope) {
        this.accessKey = accessKey;
        this.secret = secret;
        this.tenantName = tenantName;
        this.scope = scope;
    }

    public LoginWithKeyInput(String accessKey, String secret, String tenantName) {
        this.accessKey = accessKey;
        this.secret = secret;
        this.tenantName = tenantName;
    }

}
