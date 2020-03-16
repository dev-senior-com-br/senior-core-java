package br.com.senior.core.tenant;

import br.com.senior.core.tenant.pojos.GetTenantByDomainInput;
import br.com.senior.core.tenant.pojos.GetTenantByNameInput;
import br.com.senior.core.tenant.pojos.TenantOutput;
import br.com.senior.core.utils.BaseClient;
import br.com.senior.core.utils.EndpointPath;
import br.com.senior.core.utils.Environment;
import br.com.senior.core.utils.ServiceException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * Cliente do serviço de  <a href="https://dev.senior.com.br/apis/platform_tenant">Inquilino</a>
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TenantClient extends BaseClient {

    String token;

    /**
     * Construtor
     *
     * @param token
     */
    public TenantClient(String token) {
        super("platform", "tenant");
        this.token = token;
    }

    /**
     * Construtor
     *
     * @param token
     * @param env
     */
    public TenantClient(String token, Environment env) {
        super("platform", "tenant", env);
        this.token = token;
    }

    /**
     * Obtêm os dados de um tenant
     *
     * @param tenantName
     * @return
     * @throws ServiceException
     */
    public TenantOutput getTenantByName(String tenantName) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.Tenant.GET_TENANT_BY_NAME), new GetTenantByNameInput(tenantName), this.token, TenantOutput.class);
    }

    /**
     * Obtêm os dados de um tenant
     *
     * @param tenantDomain
     * @return
     * @throws ServiceException
     */
    public TenantOutput getTenantByDomain(String tenantDomain) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.Tenant.GET_TENANT_BY_DOMAIN), new GetTenantByDomainInput(tenantDomain), this.token, TenantOutput.class);
    }

}