package br.com.senior.core.base;

import br.com.senior.core.utils.EndpointPath;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * Base para os clientes dos serviços
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public abstract class BaseClient {

    Environment env;
    String domain;
    String service;

    /**
     * Construtor
     *
     * @param domain  - Domínio
     * @param service - Serviço
     */
    public BaseClient(String domain, String service) {
        this.domain = domain;
        this.service = service;
        this.env = Environment.HOMOLOG;
    }

    /**
     * Construtor
     *
     * @param domain  - Domínio
     * @param service - Serviço
     * @param env     - Variáveis de ambiente
     */
    public BaseClient(String domain, String service, Environment env) {
        this.domain = domain;
        this.service = service;
        this.env = env;
    }

    /**
     * Requisição autenticada
     *
     * @param url     - Url da requisição
     * @param payload - Payload de entrada
     * @param token   - Access-token de autenticação
     * @param clazz   - Classe de payload de saída
     * @param <T>     - Tipo de classe
     * @return - Payload de saída
     * @throws ServiceException - Erro tratado de serviço
     */
    protected <T> T execute(String url, Object payload, String token, Class<T> clazz) throws ServiceException {
        return RequestUtils.execute(url, payload, token, null, clazz);
    }

    /**
     * Remove entidade da Plataforma.
     * @param url Endpoint.
     * @param token AccessToken de authenticação.
     * @throws ServiceException Caso serviço esteja fora ou HTTP Status Code de retorno seja diferente de 2xx.
     */
    protected void delete(String url, String token) throws ServiceException {
        RequestUtils.delete(url, token);
    }

    /*
     * Requisição anônima
     *
     * @param url     - Url da requisição
     * @param payload - Payload de entrada
     * @param tenant  - Nome do tenant
     * @param clazz   - Classe de payload de saída
     * @param <T>     - Tipo de classe
     * @return - Payload de saída
     * @throws ServiceException - Erro tratado de serviço
     */
    protected <T> T executeAnonymous(String url, Object payload, String tenant, Class<T> clazz) throws ServiceException {
        return RequestUtils.execute(url, payload, null, tenant, clazz);
    }

    /**
     * Monta URL para as requisições actions
     *
     * @param path - Caminho definido no {@link EndpointPath EndpointPath}
     * @return - URL formatada
     */
    protected String getActionsUrl(String path) {
        return String.format("%s/rest/%s/%s/actions/%s", env.getUrl(), domain, service, path);
    }

    /**
     * Monta URL para as requisições queries
     *
     * @param path - Caminho definido no {@link EndpointPath EndpointPath}
     * @return - URL formatada
     */
    protected String getQueriesUrl(String path) {
        return String.format("%s/rest/%s/%s/queries/%s", env.getUrl(), domain, service, path);
    }

    /**
     * Monta URL para as requisições anônimas
     *
     * @param path - Caminho definido no {@link EndpointPath EndpointPath}
     * @return - URL formatada
     */
    protected String getAnonymousActionsUrl(String path) {
        return String.format("%s/anonymous/rest/%s/%s/actions/%s", env.getUrl(), domain, service, path);
    }

    /**
     * Constrói URL do Endpoint de exclusão.
     * @param id Identificador da entidade.
     * @param path URL da API.
     * @return String do path do Endpoint.
     */
    protected String getDelete(String id, String path) {
        return String.format("%s/rest/%s/%s", env.getUrl(), path, id);
    }
}
