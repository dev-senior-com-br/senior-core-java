package br.com.senior.core.tenant;

import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.authentication.pojos.LoginMFAInput;
import br.com.senior.core.authentication.pojos.LoginWithKeyInput;
import br.com.senior.core.base.BaseClient;
import br.com.senior.core.base.Environment;
import br.com.senior.core.base.ServiceException;
import br.com.senior.core.tenant.pojos.GetTenantByDomainInput;
import br.com.senior.core.tenant.pojos.GetTenantByNameInput;
import br.com.senior.core.tenant.pojos.TenantOutput;
import br.com.senior.core.utils.EndpointPath;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * Cliente do serviço de  <a href="https://dev.senior.com.br/api_publica/platform_tenant">tenant</a>
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TenantClient extends BaseClient {

    String token;

    /**
     * Construtor
     *
     * @param token - Access-token gerado no {@link br.com.senior.core.authentication.AuthenticationClient#login(LoginInput) login},
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginMFA(LoginMFAInput) loginMFA} e
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginWithKey(LoginWithKeyInput) loginWithKey}
     */
    public TenantClient(String token) {
        super("platform", "tenant");
        this.token = token;
    }

    /**
     * Construtor
     *
     * @param token - Access-token gerado no {@link br.com.senior.core.authentication.AuthenticationClient#login(LoginInput) login},
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginMFA(LoginMFAInput) loginMFA} e
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginWithKey(LoginWithKeyInput) loginWithKey}
     * @param env   - Variáveis de ambiente
     */
    public TenantClient(String token, Environment env) {
        super("platform", "tenant", env);
        this.token = token;
    }

    /**
     * Obtêm os dados de um tenant
     *
     * @param tenantName - Nome do tenant
     * @return - Os dados do tenant
     * @throws ServiceException - Erro tratado de serviço
     */
    public TenantOutput getTenantByName(String tenantName) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.Tenant.GET_TENANT_BY_NAME), new GetTenantByNameInput(tenantName), this.token, TenantOutput.class);
    }

    /**
     * Obtêm os dados de um tenant
     *
     * @param tenantDomain - Domínio do tenant
     * @return - Os dados do tenant
     * @throws ServiceException - Erro tratado de serviço
     */
    public TenantOutput getTenantByDomain(String tenantDomain) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.Tenant.GET_TENANT_BY_DOMAIN), new GetTenantByDomainInput(tenantDomain), this.token, TenantOutput.class);
    }

}