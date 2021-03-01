package br.com.senior.core.tenant;

import br.com.senior.core.BaseExample;
import br.com.senior.core.base.ServiceException;
import br.com.senior.core.tenant.pojos.GetTenantByDomainInput;
import br.com.senior.core.tenant.pojos.GetTenantByNameInput;
import br.com.senior.core.tenant.pojos.TenantOutput;

/**
 * Exemplos de código do Serviço Tenant
 */
public class TenantExample extends BaseExample {

    private static TenantClient client;

    /**
     * Utilizando o {@link br.com.senior.core.tenant.TenantClient TenantClient}
     *
     * @param args - Argumentos de linha de comando
     * @throws ServiceException - Erro tratado de serviço
     */
    public static void main(String[] args) throws ServiceException {

        // Login
        String accessToken = getAccessToken();

        client = new TenantClient(accessToken);


        // GetTenantByDomain
        GetTenantByDomainInput getTenantByDomainInput = GetTenantByDomainInput.builder()
                .tenantDomain(System.getenv("TENANT_DOMAIN"))
                .build();
        TenantOutput tenantByDomainOutput = client.getTenantByDomain(getTenantByDomainInput);
        System.out.println("GetTenantByDomain: " + tenantByDomainOutput.getTenant().getName());


        // GetTenantByName
        GetTenantByNameInput getTenantByNameInput = GetTenantByNameInput.builder()
                .tenantName(System.getenv("TENANT_NAME"))
                .build();
        TenantOutput tenantByNameOutput = client.getTenantByName(getTenantByNameInput);
        System.out.println("GetTenantByName: " + tenantByNameOutput.getTenant().getName());
    }

}