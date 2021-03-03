package br.com.senior.core.configuration;

import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.authentication.pojos.LoginMFAInput;
import br.com.senior.core.authentication.pojos.LoginWithKeyInput;
import br.com.senior.core.base.BaseClient;
import br.com.senior.core.base.Environment;
import br.com.senior.core.base.ServiceException;
import br.com.senior.core.configuration.pojos.CreateCustomPropertyOutput;
import br.com.senior.core.configuration.pojos.CustomPropertyValue;
import br.com.senior.core.configuration.pojos.DeleteCustomPropertyInput;
import br.com.senior.core.configuration.pojos.DeleteCustomPropertyOutput;
import br.com.senior.core.configuration.pojos.GetCustomPropertyInput;
import br.com.senior.core.configuration.pojos.UpdateCustomPropertyOutput;
import br.com.senior.core.utils.EndpointPath;

/**
 * Cliente o serviço de <a href="https://dev.senior.com.br/api_publica/platform_configuration/">Configurações</a>
 */
public class ConfigurationClient extends BaseClient {

    private String token;

    /**
     * Construtor
     *
     * @param token - Access-token gerado no {@link br.com.senior.core.authentication.AuthenticationClient#login(LoginInput) login},
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginMFA(LoginMFAInput) loginMFA} e
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginWithKey(LoginWithKeyInput) loginWithKey}
     */
    public ConfigurationClient(String token) {
        super("platform", "configuration");
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
    public ConfigurationClient(String token, Environment env) {
        super("platform", "configuration", env);
        this.token = token;
    }

    /**
     * Obtém uma propriedade customizada. Obtém apenas do tenant autenticado e no domínio platform, serviço __custom__
     *
     * @param payload - Payload de entrada com o nome da propriedade customizada
     * @return - Payload de saída com os dados da propriedade customizada
     * @throws ServiceException - Erro tratado de serviço
     */
    public CustomPropertyValue getCustomConfiguration(GetCustomPropertyInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.Configuration.GET_CUSTOM_PROPERTY), payload, this.token, CustomPropertyValue.class);
    }

    /**
     * Insere uma propriedade customizada. Insere apenas do tenant autenticado e no domínio platform, serviço __custom__
     *
     * @param payload - Payload de entrada com os dados da propriedade customizada
     * @return - Payload de saída
     * @throws ServiceException - Erro tratado de serviço
     */
    public CreateCustomPropertyOutput createCustomConfiguration(CustomPropertyValue payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.Configuration.CREATE_CUSTOM_PROPERTY), payload, this.token, CreateCustomPropertyOutput.class);
    }

    /**
     * Atualiza uma propriedade customizada. Atualiza apenas do tenant autenticado e no domínio platform, serviço __custom__
     *
     * @param payload - Payload de entrada com os dados da propriedade customizada
     * @return - Payload de saída
     * @throws ServiceException - Erro tratado de serviço
     */
    public UpdateCustomPropertyOutput updateCustomConfiguration(CustomPropertyValue payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.Configuration.UPDATE_CUSTOM_PROPERTY), payload, this.token, UpdateCustomPropertyOutput.class);
    }

    /**
     * Exclui uma propriedade customizada. Exclui apenas do tenant autenticado e no domínio platform, serviço __custom__
     *
     * @param payload - Payload de entrada com o nome da propriedade customizada
     * @return - Payload de saída
     * @throws ServiceException - Erro tratado de serviço
     */
    public DeleteCustomPropertyOutput deleteCustomProperty(DeleteCustomPropertyInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Configuration.DELETE_CUSTOM_PROPERTY), payload, this.token, DeleteCustomPropertyOutput.class);
    }
}
