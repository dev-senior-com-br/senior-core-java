package br.com.senior.core.tenant;

import br.com.senior.core.BaseExample;
import br.com.senior.core.base.ServiceException;
import br.com.senior.core.tenant.pojos.TenantOutput;

/**
 * Exemplos de código do Serviço Tenant
 */
public class TenantExample extends BaseExample {

    /**
     * Utilizando o {@link br.com.senior.core.tenant.TenantClient TenantClient}
     *
     * @param args - Argumentos de linha de comando
     * @throws ServiceException - Erro tratado de serviço
     */
    public static void main(String[] args) throws ServiceException {

        // Login
        String accessToken = getAccessToken();

        TenantClient client = new TenantClient(accessToken);


        // GetTenantByDomain
        TenantOutput tenantByDomainOutput = client.getTenantByDomain(System.getenv("TENANT_DOMAIN"));
        System.out.println("GetTenantByDomain: " + tenantByDomainOutput.getTenant().getDomain());


        // GetTenantByName
        TenantOutput tenantByNameOutput = client.getTenantByName(System.getenv("TENANT_NAME"));
        System.out.println("GetTenantByName: " + tenantByNameOutput.getTenant().getName());
    }

}