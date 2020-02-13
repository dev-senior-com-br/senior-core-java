package br.com.senior.core.authentication;

import br.com.senior.core.ServiceException;
import br.com.senior.core.authentication.pojos.*;
import org.junit.Assert;
import org.junit.Test;

public class AuthenticationIT {

    private static final String VALID_USERNAME = "login@dominio.com.br";
    private static final String VALID_PASSWORD = "senha";
    private static final String INVALID_PASSWORD = "senha_errada";

    @Test
    public void testValidLogin() throws ServiceException {
        AuthenticationClient client = new AuthenticationClient();
        LoginOutput output = client.login(new LoginInput(VALID_USERNAME, VALID_PASSWORD));
        Assert.assertNotNull(output.getJsonToken());
        Assert.assertNotNull(output.getJsonToken().getAccess_token());
    }

    @Test
    public void testInvalidLogin() {
        AuthenticationClient client = new AuthenticationClient();
        Assert.assertThrows(ServiceException.class, () -> client.login(new LoginInput(VALID_USERNAME, INVALID_PASSWORD)));
    }

    @Test
    public void testValidLoginMFA() throws ServiceException {
        final String temporaryToken = "token";
        final Long validationCode = 1L;
        AuthenticationClient client = new AuthenticationClient();
        LoginMFAOutput output = client.loginMFA(new LoginMFAInput(temporaryToken, validationCode));
        Assert.assertNotNull(output.getJsonToken());
    }

    @Test
    public void testInvalidLoginMFA() {
        final String temporaryToken = "token";
        final Long validationCode = 1L;
        AuthenticationClient client = new AuthenticationClient();
        Assert.assertThrows(ServiceException.class, () -> client.loginMFA(new LoginMFAInput(temporaryToken, validationCode)));
    }

    @Test
    public void testValidLoginWithKey() throws ServiceException {
        final String accessKey = "accessKey";
        final String secret = "secret";
        final String tenant = "tenant";
        AuthenticationClient client = new AuthenticationClient();
        LoginWithKeyOutput output = client.loginWithKey(new LoginWithKeyInput(accessKey, secret, tenant));
        Assert.assertNotNull(output.getJsonToken());
    }

    @Test
    public void testInvalidLoginWithKey() {
        final String accessKey = "accessKey";
        final String secret = "secret";
        final String tenant = "tenant";
        AuthenticationClient client = new AuthenticationClient();
        Assert.assertThrows(ServiceException.class, () -> client.loginWithKey(new LoginWithKeyInput(accessKey, secret, tenant)));
    }

    @Test
    public void testValidLogout() throws ServiceException {
        final String token = "token";
        AuthenticationClient client = new AuthenticationClient();
        LogoutOutput output = client.logout(new LogoutInput(token));
        Assert.assertNotNull(output);
    }
}