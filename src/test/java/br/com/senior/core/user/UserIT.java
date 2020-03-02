package br.com.senior.core.user;

import org.junit.Assert;
import org.junit.Test;

import br.com.senior.core.BaseIT;
import br.com.senior.core.ServiceException;
import br.com.senior.core.authentication.pojos.LoginOutput;
import br.com.senior.core.user.pojos.GetUserInput;
import br.com.senior.core.user.pojos.GetUserOutput;

public class UserIT extends BaseIT {

    @Test
    public void testGetUser() throws ServiceException {

        LoginOutput loginOutput = login();
        String token = loginOutput.getJsonToken().getAccess_token();
        String username = loginOutput.getJsonToken().getUsername();

        GetUserInput payload = new GetUserInput(username);
        GetUserOutput output = new UserClient().getUser(payload, token);

        Assert.assertNotNull(output.getTenantName());

    }

}