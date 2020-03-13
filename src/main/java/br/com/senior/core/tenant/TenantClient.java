package br.com.senior.core.tenant;

import br.com.senior.core.tenant.dto.GetTenantByDomainInput;
import br.com.senior.core.tenant.dto.GetTenantByNameInput;
import br.com.senior.core.tenant.dto.TenantOutput;
import br.com.senior.core.utils.BaseClient;
import br.com.senior.core.utils.EndpointPath;
import br.com.senior.core.utils.Environment;
import br.com.senior.core.utils.ServiceException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class TenantClient extends BaseClient {

    public TenantClient() {
        super("platform", "tenant");
    }

    public TenantClient(Environment env) {
        super("platform", "tenant", env);
    }

    public TenantOutput getTenantByName(String tenantName, String token) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.GET_TENANT_BY_NAME), new GetTenantByNameInput(tenantName), token, TenantOutput.class);
    }

    public TenantOutput getTenantByDomain(String tenantDomain, String token) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.GET_TENANT_BY_DOMAIN), new GetTenantByDomainInput(tenantDomain), token, TenantOutput.class);
    }

}