package br.com.senior.core.authentication;

import br.com.senior.core.Scope;
import br.com.senior.core.ServiceException;
import br.com.senior.core.authentication.pojos.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class AuthenticationIT {

    @Test
    public void testValidLogin() throws ServiceException {
        LoginOutput output = login();
        Assert.assertNotNull(output.getJsonToken());
        Assert.assertNotNull(output.getJsonToken().getAccess_token());
    }

    @Test
    public void testInvalidLogin() {
        LoginInput input = new LoginInput(System.getenv("username"), System.getenv("password_invalid"));
        Assert.assertThrows(ServiceException.class, () -> new AuthenticationClient().login(input));
    }

    @Test
    @Ignore("Como depende do código de validação que irá aparecer na tela do usuário não é possível rodar de forma automatizada")
    public void testValidLoginMFA() throws ServiceException {
        LoginOutput login = login(System.getenv("username_mfa"), System.getenv("password_mfa"));
        final Long validationCode = 1L; //Esse código vai aparecer no dispositivo configurado para login multifator e deve ser informado pelo usuário
        LoginMFAInput input = new LoginMFAInput(login.getMfaInfo().getTemporaryToken(), validationCode);
        Assert.assertThrows(ServiceException.class, () -> new AuthenticationClient().loginMFA(input));
    }

    @Test
    public void testInvalidLoginMFA() throws ServiceException {
        LoginOutput login = login(System.getenv("username_mfa"), System.getenv("password_mfa"));
        Assert.assertNotNull("O usuário informado deveria estar configurado para login multifator", login.getMfaInfo());

        final Long invalidCode = 1L;
        LoginMFAInput input = new LoginMFAInput(login.getMfaInfo().getTemporaryToken(), invalidCode);
        Assert.assertThrows(ServiceException.class, () -> new AuthenticationClient().loginMFA(input));
    }

    @Test
    public void testValidLoginWithKey() throws ServiceException {
        LoginWithKeyInput input = new LoginWithKeyInput(System.getenv("access_key"), System.getenv("secret"), System.getenv("tenant"));
        LoginWithKeyOutput output = new AuthenticationClient().loginWithKey(input);
        Assert.assertNotNull(output.getJsonToken());
    }

    @Test
    public void testInvalidLoginWithKey() {
        LoginWithKeyInput input = new LoginWithKeyInput(System.getenv("access_key"), System.getenv("secret"), System.getenv("tenant"));
        Assert.assertThrows(ServiceException.class, () -> new AuthenticationClient().loginWithKey(input));
    }

    @Test
    public void testValidLogout() throws ServiceException {
        LoginOutput login = login();
        LogoutInput input = new LogoutInput(login.getJsonToken().getAccess_token());
        LogoutOutput output = new AuthenticationClient().logout(input);
        Assert.assertNotNull(output);
    }

    @Test
    public void testRefreshToken() throws ServiceException {
        LoginOutput loginOutput = login();
        RefreshTokenInput input = new RefreshTokenInput(loginOutput.getJsonToken().getRefresh_token(), Scope.DESKTOP.toString().toLowerCase());
        RefreshTokenOutput output = new AuthenticationClient().refreshToken(input);
        Assert.assertNotNull(input.getRefreshToken());
        Assert.assertNotNull(input.getScope());
        Assert.assertNotNull(output.getJsonToken());
    }

    @Test
    public void testRefreshTokenScopeNull() throws ServiceException {
        LoginOutput output = login();
        RefreshTokenInput input = new RefreshTokenInput(output.getJsonToken().getRefresh_token());
        Assert.assertNotNull(input.getRefreshToken());
        Assert.assertNull(input.getScope());
    }

    private LoginOutput login() throws ServiceException {
        return login(System.getenv("username"), System.getenv("password_valid"));
    }

    private LoginOutput login(String username, String password) throws ServiceException {
        LoginInput input = new LoginInput(username, password);
        return new AuthenticationClient().login(input);
    }
}