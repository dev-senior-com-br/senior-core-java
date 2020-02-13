package br.com.senior.core.authentication;

import br.com.senior.core.BaseClient;
import br.com.senior.core.Environment;
import br.com.senior.core.ServiceException;
import br.com.senior.core.authentication.pojos.*;
import com.google.gson.GsonBuilder;

import java.util.Optional;

public class AuthenticationClient extends BaseClient {

    public AuthenticationClient() {
        super("platform", "authentication");
    }

    public AuthenticationClient(Environment env) {
        super("platform", "authentication", env);
    }

    /**
     * Realiza login na plataforma.
     * O login pode ser realizado informando usuário e senha OU o código de autorização obtido de um provedor externo (SAML, por exemplo).
     * Se o usuário/tenant estiver configurado para usar autenticação multifator, será retornado, dentro do objeto 'mfaInfo', um token temporário que deverá ser utilizado na primitiva loginMFA para efetivamente realizar o login.
     */
    public LoginOutput login(LoginInput payload) throws ServiceException {
        GsonBuilder gson = new GsonBuilder();
        String str = execute(getActionsUrl() + "login", payload);
        LoginInternalOutput internalOutput = gson.create().fromJson(str, LoginInternalOutput.class);
        SeniorJsonToken jsonToken = Optional.ofNullable(internalOutput.getJsonToken()).map(json -> gson.create().fromJson(json, SeniorJsonToken.class)).orElse(null);
        return new LoginOutput(jsonToken, internalOutput.getMfaInfo(), internalOutput.getResetPasswordInfo());
    }

    /**
     * Realiza o login na plataforma por meio de um código de validação OTP (One-time password) gerado pelo Google Authenticator.
     * Além do código de validação, é necessário informar o token temporário que foi retornado pela primitiva 'login', que é sempre o primeiro passo da autenticação.
     */
    public LoginMFAOutput loginMFA(LoginMFAInput payload) throws ServiceException {
        GsonBuilder gson = new GsonBuilder();
        return gson.create().fromJson(execute(getActionsUrl() + "loginMFA", payload), LoginMFAOutput.class);
    }

    /**
     * Realiza login na plataforma com chave e segredo informados pelo usuário.
     */
    public LoginWithKeyOutput loginWithKey(LoginWithKeyInput payload) throws ServiceException {
        GsonBuilder gson = new GsonBuilder();
        return gson.create().fromJson(execute(getActionsUrl() + "loginWithKey", payload), LoginWithKeyOutput.class);
    }

    /**
     * Invalida o token de acesso informado e publica um evento informando que o usuário realizou logout.
     */
    public LogoutOutput logout(LogoutInput payload) throws ServiceException {
        GsonBuilder gson = new GsonBuilder();
        return gson.create().fromJson(execute(getActionsUrl() + "logout", payload, payload.getAccessToken()), LogoutOutput.class);
    }
}
