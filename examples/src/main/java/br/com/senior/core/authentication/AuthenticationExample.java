package br.com.senior.core.authentication;

import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.authentication.pojos.LoginMFAInput;
import br.com.senior.core.authentication.pojos.LoginMFAOutput;
import br.com.senior.core.authentication.pojos.LoginOutput;
import br.com.senior.core.authentication.pojos.LoginWithKeyInput;
import br.com.senior.core.authentication.pojos.LoginWithKeyOutput;
import br.com.senior.core.authentication.pojos.LogoutInput;
import br.com.senior.core.authentication.pojos.RefreshTokenInput;
import br.com.senior.core.authentication.pojos.RefreshTokenOutput;
import br.com.senior.core.authentication.pojos.Scope;
import br.com.senior.core.base.ServiceException;

/**
 * Exemplos de código do Serviço Authentication
 */
public class AuthenticationExample {

    private static AuthenticationClient client;

    /**
     * Utilizando o {@link br.com.senior.core.authentication.AuthenticationClient AuthenticationClient}
     *
     * @param args - Argumentos de linha de comando
     * @throws ServiceException - Erro tratado de serviço
     */
    public static void main(String[] args) throws ServiceException {

        client = new AuthenticationClient();

        // Login
        String username = System.getenv("SENIOR_USERNAME");
        String password = System.getenv("PASS");
        String tenantName = System.getenv("TENANT_NAME");

        LoginInput loginInput = LoginInput.builder()
                .username(username)
                .password(password)
                .build();
        LoginOutput loginOutput = client.login(loginInput);

        String accessToken = loginOutput.getJsonToken().getAccessToken();
        System.out.println("Login - Access-Token: " + accessToken);

        String refreshToken = loginOutput.getJsonToken().getRefreshToken();
        System.out.println("Login - Refresh-Token: " + refreshToken);


        // RefreshToken
        RefreshTokenInput refreshTokenInput = RefreshTokenInput.builder()
                .refreshToken(refreshToken)
                .scope(Scope.DESKTOP.name())
                .build();
        RefreshTokenOutput refreshTokenOutput = client.refreshToken(refreshTokenInput, tenantName);

        accessToken = refreshTokenOutput.getJsonToken().getAccessToken();
        System.out.println("RefreshToken - Access-Token: " + accessToken);


        // Logout
        LogoutInput logoutInput = LogoutInput.builder()
                .accessToken(accessToken)
                .build();
        client.logout(logoutInput);


        // LoginWithKey
        String accessKey = System.getenv("ACCESS_KEY");
        String secret = System.getenv("SECRET");

        LoginWithKeyInput loginWithKeyInput = LoginWithKeyInput.builder()
                .accessKey(accessKey)
                .secret(secret)
                .tenantName(tenantName)
                .build();
        LoginWithKeyOutput loginWithKeyOutput = client.loginWithKey(loginWithKeyInput);

        accessToken = loginWithKeyOutput.getJsonToken().getAccessToken();
        System.out.println("LoginWithKey - Access-Token: " + accessToken);


        // LoginMFA
        String usernameMFA = System.getenv("USERNAME_MFA");
        String passwordMFA = System.getenv("PASSWORD_MFA");

        loginInput = LoginInput.builder()
                .username(usernameMFA)
                .password(passwordMFA)
                .build();
        loginOutput = client.login(loginInput);

        String validationCode = "021669"; //Esse código vai aparecer no dispositivo configurado para login multi-fator e deve ser informado pelo usuário
        String temporaryToken = loginOutput.getMfaInfo().getTemporaryToken();
        System.out.println("LoginMFA - Temporary-Token: " + temporaryToken);

        LoginMFAInput loginMFAInput = LoginMFAInput.builder()
                .temporaryToken(temporaryToken)
                .validationCode(validationCode)
                .build();
        LoginMFAOutput loginMFAOutput = client.loginMFA(loginMFAInput);

        accessToken = loginMFAOutput.getJsonToken().getAccessToken();
        System.out.println("LoginMFA - Access-Token: " + accessToken);
    }

}
