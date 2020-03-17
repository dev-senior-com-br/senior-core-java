package br.com.senior.core.utils;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public abstract class BaseClient {

    Environment env;
    String domain;
    String service;

    public BaseClient(String domain, String service) {
        this.domain = domain;
        this.service = service;
        this.env = Environment.HOMOLOG;
    }

    public BaseClient(String domain, String service, Environment env) {
        this.domain = domain;
        this.service = service;
        this.env = env;
    }

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

    protected <T> T executeAnonymous(String url, Object payload, String tenant, Class<T> clazz) throws ServiceException {
        return RequestUtils.execute(url, payload, null, tenant, clazz);
    }

    protected String getActionsUrl(String path) {
        return String.format("%s/rest/%s/%s/actions/%s", env.getUrl(), domain, service, path);
    }

    protected String getQueriesUrl(String path) {
        return String.format("%s/rest/%s/%s/queries/%s", env.getUrl(), domain, service, path);
    }

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
