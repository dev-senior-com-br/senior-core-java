package br.com.senior.core;

import br.com.senior.core.authentication.AuthenticationClient;
import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.authentication.pojos.LoginOutput;
import br.com.senior.core.utils.ServiceException;

/**
 * Base para as classes de testes
 */
public abstract class BaseIT {

    protected static LoginOutput login() throws ServiceException {
        return login(System.getenv("SENIOR_USERNAME"), System.getenv("PASS"));
    }

    protected static LoginOutput login(String username, String password) throws ServiceException {
        LoginInput input = new LoginInput(username, password);
        return new AuthenticationClient().login(input);
    }

}
