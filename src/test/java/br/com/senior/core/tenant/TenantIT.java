package br.com.senior.core.tenant;

import br.com.senior.core.BaseIT;
import br.com.senior.core.authentication.AuthenticationClient;
import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.tenant.dto.TenantOutput;
import br.com.senior.core.utils.ServiceException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TenantIT extends BaseIT {

    private static String token;
    private TenantClient client = new TenantClient();

    @BeforeClass
    public static void beforeClass() throws ServiceException {
        token = new AuthenticationClient().login(new LoginInput(System.getenv("SENIOR_USERNAME"), System.getenv("PASSWORD_VALID"))).getJsonToken().getAccess_token();
    }

    @Test
    public void testGetTenantByDomain() throws ServiceException {
        TenantOutput tenantByDomain = client.getTenantByDomain(System.getenv("TENANT_DOMAIN"), token);
        Assert.assertNotNull(tenantByDomain);
    }

    @Test
    public void testGetTenantByName() throws ServiceException {
        TenantOutput tenantByName = client.getTenantByName(System.getenv("TENANT_NAME"), token);
        Assert.assertNotNull(tenantByName);
    }
}