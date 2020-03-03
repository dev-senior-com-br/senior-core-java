package br.com.senior.core.authentication;

import java.util.Optional;

import com.google.gson.GsonBuilder;

import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.authentication.pojos.LoginInternalOutput;
import br.com.senior.core.authentication.pojos.LoginMFAInput;
import br.com.senior.core.authentication.pojos.LoginMFAOutput;
import br.com.senior.core.authentication.pojos.LoginOutput;
import br.com.senior.core.authentication.pojos.LoginWithKeyInput;
import br.com.senior.core.authentication.pojos.LoginWithKeyOutput;
import br.com.senior.core.authentication.pojos.LogoutInput;
import br.com.senior.core.authentication.pojos.LogoutOutput;
import br.com.senior.core.authentication.pojos.RefreshTokenInput;
import br.com.senior.core.authentication.pojos.RefreshTokenInternalOutput;
import br.com.senior.core.authentication.pojos.RefreshTokenOutput;
import br.com.senior.core.authentication.pojos.SeniorJsonRefreshToken;
import br.com.senior.core.authentication.pojos.SeniorJsonToken;
import br.com.senior.core.utils.BaseClient;
import br.com.senior.core.utils.Environment;
import br.com.senior.core.utils.ServiceException;

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
        String str = executeAnonymous(getActionsUrl() + "login", payload, null);
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
        return gson.create().fromJson(executeAnonymous(getActionsUrl() + "loginMFA", payload, null), LoginMFAOutput.class);
    }

    /**
     * Realiza login na plataforma com chave e segredo informados pelo usuário.
     */
    public LoginWithKeyOutput loginWithKey(LoginWithKeyInput payload) throws ServiceException {
        GsonBuilder gson = new GsonBuilder();
        return gson.create().fromJson(executeAnonymous(getAnonymousActionsUrl() + "loginWithKey", payload, null), LoginWithKeyOutput.class);
    }

    /**
     * Invalida o token de acesso informado e publica um evento informando que o usuário realizou logout.
     */
    public LogoutOutput logout(LogoutInput payload) throws ServiceException {
        GsonBuilder gson = new GsonBuilder();
        return gson.create().fromJson(execute(getActionsUrl() + "logout", payload, payload.getAccessToken()), LogoutOutput.class);
    }

    /**
     * Gera um novo token a partir de um refresh_token.
     */
    public RefreshTokenOutput refreshToken(RefreshTokenInput payload, String tenant) throws ServiceException {
        GsonBuilder gson = new GsonBuilder();
        String str = executeAnonymous(getActionsUrl() + "refreshToken", payload, tenant);
        RefreshTokenInternalOutput internalOutput = gson.create().fromJson(str, RefreshTokenInternalOutput.class);
        SeniorJsonRefreshToken jsonToken = Optional.ofNullable(internalOutput.getJsonToken()).map(json -> gson.create().fromJson(json, SeniorJsonRefreshToken.class)).orElse(null);
        return new RefreshTokenOutput(jsonToken);
    }

}
