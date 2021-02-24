package br.com.senior.examples.authentication;

import br.com.senior.core.authentication.AuthenticationClient;
import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.authentication.pojos.LoginMFAInput;
import br.com.senior.core.authentication.pojos.LoginOutput;
import br.com.senior.core.authentication.pojos.LoginWithKeyInput;
import br.com.senior.core.authentication.pojos.LoginWithKeyOutput;
import br.com.senior.core.authentication.pojos.LogoutInput;
import br.com.senior.core.authentication.pojos.RefreshTokenInput;
import br.com.senior.core.authentication.pojos.RefreshTokenOutput;
import br.com.senior.core.authentication.pojos.Scope;
import br.com.senior.core.base.ServiceException;

/**
 * Exemplos de código do {@link br.com.senior.core.authentication.AuthenticationClient AuthenticationClient}
 */
public class AuthenticationExample {

    private static final AuthenticationClient client = new AuthenticationClient();

    public static void main(String[] args) throws ServiceException {

        String username = System.getenv("SENIOR_USERNAME");
        String password = System.getenv("PASS");
        String tenantName = System.getenv("TENANT_NAME");

        LoginOutput loginOutput = loginDefault(username, password);
        String accessToken = loginOutput.getJsonToken().getAccessToken();
        logout(accessToken);

        loginOutput = loginDefault(username, password);
        String refreshToken = loginOutput.getJsonToken().getRefreshToken();

        RefreshTokenInput refreshTokenInput = new RefreshTokenInput(refreshToken, Scope.DESKTOP.name());
        RefreshTokenOutput refreshTokenOutput = client.refreshToken(refreshTokenInput, tenantName);
        accessToken = refreshTokenOutput.getJsonToken().getAccessToken();
        logout(accessToken);

        String accessKey = System.getenv("ACCESS_KEY");
        String secret = System.getenv("SECRET");

        LoginWithKeyOutput loginWithKeyOutput = loginWithKey(accessKey, secret, tenantName);
        accessToken = loginWithKeyOutput.getJsonToken().getAccessToken();
        logout(accessToken);

        String usernameMFA = System.getenv("USERNAME_MFA");
        String passwordMFA = System.getenv("PASSWORD_MFA");

        LoginOutput loginMFA = loginDefault(usernameMFA, passwordMFA);
        int validationCode = -1; //Esse código vai aparecer no dispositivo configurado para login multi-fator e deve ser informado pelo usuário

        loginMFA(loginMFA.getMfaInfo().getTemporaryToken(), validationCode);
    }

    private static LoginWithKeyOutput loginWithKey(String accessKey, String secret, String tenantName) throws ServiceException {
        LoginWithKeyInput loginWithKeyInput = new LoginWithKeyInput(accessKey, secret, tenantName);
        return client.loginWithKey(loginWithKeyInput);
    }

    private static void loginMFA(String temporaryToken, int validationCode) throws ServiceException {
        LoginMFAInput loginMFAInput = new LoginMFAInput(temporaryToken, validationCode);
        client.loginMFA(loginMFAInput);
    }

    private static LoginOutput loginDefault(String user, String pwd) throws ServiceException {
        LoginInput loginInput = new LoginInput(user, pwd);
        return client.login(loginInput);
    }

    private static void logout(String accessToken) throws ServiceException {
        LogoutInput logoutInput = new LogoutInput(accessToken);
        client.logout(logoutInput);
    }

}
