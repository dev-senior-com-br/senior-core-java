package br.com.senior.core;

import br.com.senior.core.authentication.AuthenticationClient;
import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.authentication.pojos.LoginOutput;
import br.com.senior.core.base.ServiceException;

/**
 * Base para as classes de testes
 */
public abstract class BaseIT {

    protected static LoginOutput login() throws ServiceException {
        LoginOutput login = login(System.getenv("SENIOR_USERNAME"), System.getenv("PASS"));
        if (login.getResetPasswordInfo() != null) {
            throw new ServiceException(400, "Usuário informado inválido para os testes, é necessário fazer o login na plataforma ao menos uma vez após a sua criação para realizar a troca da senha.");
        }
        return login;
    }

    protected static LoginOutput login(String username, String password) throws ServiceException {
        LoginInput input = new LoginInput(username, password);
        return new AuthenticationClient().login(input);
    }

}
