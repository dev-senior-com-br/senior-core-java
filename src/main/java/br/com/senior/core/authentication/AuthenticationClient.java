package br.com.senior.core.authentication;

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
import br.com.senior.core.authentication.pojos.SeniorJsonToken;
import br.com.senior.core.utils.BaseClient;
import br.com.senior.core.utils.EndpointPath;
import br.com.senior.core.utils.Environment;
import br.com.senior.core.utils.ServiceException;

import java.util.Optional;

import com.google.gson.Gson;

/**
 * Cliente do serviço de  <a href="https://dev.senior.com.br/apis/platform_authentication">Autenticação</a>
 */
public class AuthenticationClient extends BaseClient {

    /**
     * Construtor
     */
    public AuthenticationClient() {
        super("platform", "authentication");
    }

    /**
     * Construtor
     *
     * @param env - Variáveis de ambiente
     */
    public AuthenticationClient(Environment env) {
        super("platform", "authentication", env);
    }

    /**
     * Realiza login na plataforma.
     * O login pode ser realizado informando usuário e senha OU o código de autorização obtido de um provedor externo (SAML, por exemplo).
     * Se o usuário/tenant estiver configurado para usar autenticação multifator, será retornado, dentro do objeto 'mfaInfo', um token temporário que deverá ser utilizado na primitiva loginMFA para efetivamente realizar o login.
     *
     * @param payload - Payload de entrada com os dados para autenticação
     * @return - Payload de saída com os tokens de autenticação
     * @throws ServiceException - Erro tratado de serviço
     */
    public LoginOutput login(LoginInput payload) throws ServiceException {
        LoginInternalOutput internalOutput = executeAnonymous(getActionsUrl(EndpointPath.Authentication.LOGIN), payload, null, LoginInternalOutput.class);
        SeniorJsonToken jsonToken = Optional.ofNullable(internalOutput.getJsonToken()).map(json -> new Gson().fromJson(json, SeniorJsonToken.class)).orElse(null);
        return new LoginOutput(jsonToken, internalOutput.getMfaInfo(), internalOutput.getResetPasswordInfo());
    }

    /**
     * Realiza o login na plataforma por meio de um código de validação OTP (One-time password) gerado pelo Google Authenticator.
     * Além do código de validação, é necessário informar o token temporário que foi retornado pela primitiva 'login', que é sempre o primeiro passo da autenticação.
     *
     * @param payload - Payload de entrada com os dados para autenticação
     * @return - Payload de saída com os tokens de autenticação
     * @throws ServiceException - Erro tratado de serviço
     */
    public LoginMFAOutput loginMFA(LoginMFAInput payload) throws ServiceException {
        return executeAnonymous(getActionsUrl(EndpointPath.Authentication.LOGIN_MFA), payload, null, LoginMFAOutput.class);
    }

    /**
     * Realiza login na plataforma com chave e segredo informados pelo usuário.
     *
     * @param payload - Payload de entrada com os dados para autenticação
     * @return - Payload de saída com os tokens de autenticação
     * @throws ServiceException - Erro tratado de serviço
     */
    public LoginWithKeyOutput loginWithKey(LoginWithKeyInput payload) throws ServiceException {
        return executeAnonymous(getAnonymousActionsUrl(EndpointPath.Authentication.LOGIN_WITH_KEY), payload, null, LoginWithKeyOutput.class);
    }

    /**
     * Invalida o token de acesso informado e publica um evento informando que o usuário realizou logout.
     *
     * @param payload - Payload de entrada com o token de acesso
     * @return - Payload de saída vazio
     * @throws ServiceException - Erro tratado de serviço
     */
    public LogoutOutput logout(LogoutInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authentication.LOGOUT), payload, payload.getAccessToken(), LogoutOutput.class);
    }

    /**
     * Gera um novo token a partir de um refresh_token.
     *
     * @param payload - Payload de entrada com o token de atualização
     * @param tenant  - Nome do tenant
     * @return - Payload de saída com os tokens de autenticação
     * @throws ServiceException - Erro tratado de serviço
     */
    public RefreshTokenOutput refreshToken(RefreshTokenInput payload, String tenant) throws ServiceException {
        RefreshTokenInternalOutput internalOutput = executeAnonymous(getActionsUrl(EndpointPath.Authentication.REFRESH_TOKEN), payload, tenant, RefreshTokenInternalOutput.class);
        SeniorJsonToken jsonToken = Optional.ofNullable(internalOutput.getJsonToken()).map(json -> new Gson().fromJson(json, SeniorJsonToken.class)).orElse(null);
        return new RefreshTokenOutput(jsonToken);
    }

}
