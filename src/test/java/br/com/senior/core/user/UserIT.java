package br.com.senior.core.user;

import br.com.senior.core.BaseIT;
import br.com.senior.core.authentication.pojos.LoginOutput;
import br.com.senior.core.user.pojos.GetUserInput;
import br.com.senior.core.user.pojos.GetUserOutput;
import br.com.senior.core.utils.ServiceException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class UserIT extends BaseIT {

    private static String usernameExpected;

    @BeforeClass
    public static void beforeClass() {
        usernameExpected = Arrays.stream(System.getenv("USERNAME").split("@")).findFirst().orElse(null);
    }

    @Test
    public void testGetUser() throws ServiceException {

        LoginOutput loginOutput = login();
        String token = loginOutput.getJsonToken().getAccess_token();
        String username = loginOutput.getJsonToken().getUsername();

        GetUserInput payload = new GetUserInput(username);
        GetUserOutput output = new UserClient().getUser(payload, token);

        Assert.assertNotNull(output);
        Assert.assertEquals(usernameExpected, output.getUsername());

    }

    @Test
    public void testGetUserNull() throws ServiceException {

        LoginOutput loginOutput = login();
        String token = loginOutput.getJsonToken().getAccess_token();

        GetUserInput payload = new GetUserInput(null);
        GetUserOutput output = new UserClient().getUser(payload, token);

        Assert.assertNotNull(output);
        Assert.assertEquals(usernameExpected, output.getUsername());

    }

}