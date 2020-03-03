package br.com.senior.core;

import br.com.senior.core.authentication.AuthenticationClient;
import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.authentication.pojos.LoginOutput;
import br.com.senior.core.utils.ServiceException;

public class BaseIT {

    protected LoginOutput login() throws ServiceException {
        return login(System.getenv("username"), System.getenv("password_valid"));
    }

    protected LoginOutput login(String username, String password) throws ServiceException {
        LoginInput input = new LoginInput(username, password);
        return new AuthenticationClient().login(input);
    }

}
