package br.com.senior.core;

import br.com.senior.core.authentication.AuthenticationClient;
import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.authentication.pojos.LoginOutput;
import br.com.senior.core.base.ServiceException;

import org.apache.commons.lang3.StringUtils;

public abstract class BaseExample {

    protected static String getAccessToken() throws ServiceException {
        String accessToken = login().getJsonToken().getAccessToken();
        System.out.println("Access-Token: " + accessToken);
        return accessToken;
    }

    protected static LoginOutput login() throws ServiceException {
        LoginOutput login = login(System.getenv("SENIOR_USERNAME"), System.getenv("PASS"));
        if (login.getResetPasswordInfo() != null) {
            throw new ServiceException(400, "Usuário informado inválido para os testes, é necessário fazer o login na plataforma ao menos uma vez após a sua criação para realizar a troca da senha.");
        }
        return login;
    }

    protected static LoginOutput login(String username, String password) throws ServiceException {
        LoginInput input = LoginInput.builder()
                .username(username)
                .password(password)
                .build();
        return new AuthenticationClient().login(input);
    }

    protected static String getUsernameWithoutDomain() {
        return StringUtils.substringBefore(System.getenv("SENIOR_USERNAME"), "@");
    }
}
