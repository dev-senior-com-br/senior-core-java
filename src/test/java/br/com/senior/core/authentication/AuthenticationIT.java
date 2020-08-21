package br.com.senior.core.authentication;

import br.com.senior.core.BaseIT;
import br.com.senior.core.authentication.pojos.LoginMFAInput;
import br.com.senior.core.authentication.pojos.LoginOutput;
import br.com.senior.core.authentication.pojos.LoginWithKeyInput;
import br.com.senior.core.authentication.pojos.LoginWithKeyOutput;
import br.com.senior.core.authentication.pojos.LogoutInput;
import br.com.senior.core.authentication.pojos.LogoutOutput;
import br.com.senior.core.authentication.pojos.RefreshTokenInput;
import br.com.senior.core.authentication.pojos.RefreshTokenOutput;
import br.com.senior.core.authentication.pojos.Scope;
import br.com.senior.core.base.ServiceException;
import br.com.senior.core.user.UserClient;
import br.com.senior.core.user.pojos.GetUserInput;
import br.com.senior.core.user.pojos.GetUserOutput;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Exemplos de código do {@link br.com.senior.core.authentication.AuthenticationClient AuthenticationClient}
 */
public class AuthenticationIT extends BaseIT {

    @Test
    public void testValidLogin() throws ServiceException {
        LoginOutput output = login();
        Assert.assertNotNull(output.getJsonToken());
        Assert.assertNotNull(output.getJsonToken().getAccess_token());
    }

    @Test
    public void testInvalidLogin() {
        Assert.assertThrows(ServiceException.class, () -> login(System.getenv("SENIOR_USERNAME"), System.getenv("PASSWORD_INVALID")));
    }

    @Test
    @Ignore("Como depende do código de validação que irá aparecer na tela do usuário não é possível rodar de forma automatizada")
    public void testValidLoginMFA() throws ServiceException {
        LoginOutput login = login(System.getenv("USERNAME_MFA"), System.getenv("PASSWORD_MFA"));
        final Long validationCode = 1L; //Esse código vai aparecer no dispositivo configurado para login multifator e deve ser informado pelo usuário
        LoginMFAInput input = new LoginMFAInput(login.getMfaInfo().getTemporaryToken(), validationCode);
        Assert.assertThrows(ServiceException.class, () -> new AuthenticationClient().loginMFA(input));
    }

    @Test
    public void testInvalidLoginMFA() throws ServiceException {
        LoginOutput login = login(System.getenv("USERNAME_MFA"), System.getenv("PASSWORD_MFA"));
        Assert.assertNotNull("O usuário informado deveria estar configurado para login multifator", login.getMfaInfo());

        final Long invalidCode = 1L;
        LoginMFAInput input = new LoginMFAInput(login.getMfaInfo().getTemporaryToken(), invalidCode);
        Assert.assertThrows(ServiceException.class, () -> new AuthenticationClient().loginMFA(input));
    }

    @Test
    public void testValidLoginWithKey() throws ServiceException {
        LoginWithKeyInput input = new LoginWithKeyInput(System.getenv("ACCESS_KEY"), System.getenv("SECRET"), System.getenv("TENANT"));
        LoginWithKeyOutput output = new AuthenticationClient().loginWithKey(input);
        Assert.assertNotNull(output.getJsonToken());
    }

    @Test
    public void testInvalidLoginWithKey() {
        LoginWithKeyInput input = new LoginWithKeyInput(System.getenv("ACCESS_KEY"), System.getenv("SECRET"), System.getenv("TENANT"));
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
    public void testRefreshTokenWithScope() throws ServiceException {

        LoginOutput loginOutput = login();
        String username = loginOutput.getJsonToken().getUsername();
        String accessToken = loginOutput.getJsonToken().getAccess_token();
        String refreshToken = loginOutput.getJsonToken().getRefresh_token();

        GetUserInput getUserInput = new GetUserInput(username);
        GetUserOutput getUserOutput = new UserClient(accessToken).getUser(getUserInput);

        RefreshTokenInput refreshTokenInput = new RefreshTokenInput(refreshToken, Scope.DESKTOP.toString());
        RefreshTokenOutput output = new AuthenticationClient().refreshToken(refreshTokenInput, getUserOutput.getTenantName());

        Assert.assertNotNull(output.getJsonToken());
        Assert.assertEquals(username, output.getJsonToken().getUsername());
    }

    @Test
    public void testRefreshTokenScopeLess() throws ServiceException {
        LoginOutput loginOutput = login();
        String username = loginOutput.getJsonToken().getUsername();
        String accessToken = loginOutput.getJsonToken().getAccess_token();
        String refreshToken = loginOutput.getJsonToken().getRefresh_token();

        GetUserInput getUserInput = new GetUserInput(username);
        GetUserOutput getUserOutput = new UserClient(accessToken).getUser(getUserInput);

        RefreshTokenInput refreshTokenInput = new RefreshTokenInput(refreshToken);
        RefreshTokenOutput output = new AuthenticationClient().refreshToken(refreshTokenInput, getUserOutput.getTenantName());

        Assert.assertNotNull(output.getJsonToken());
        Assert.assertEquals(username, output.getJsonToken().getUsername());
    }

}
