package br.com.senior.core.utils;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

/**
 * Base para os clientes dos serviços
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public abstract class BaseClient {

    Environment env;
    String domain;
    String service;

    /**
     * Construtor
     *
     * @param domain
     * @param service
     */
    public BaseClient(String domain, String service) {
        this.domain = domain;
        this.service = service;
        this.env = Environment.HOMOLOG;
    }

    /**
     * Construtor
     *
     * @param domain
     * @param service
     * @param env
     */
    public BaseClient(String domain, String service, Environment env) {
        this.domain = domain;
        this.service = service;
        this.env = env;
    }

    /**
     * Requisição autenticada
     *
     * @param url
     * @param payload
     * @param token
     * @param clazz
     * @param <T>
     * @return
     * @throws ServiceException
     */
    protected <T> T execute(String url, Object payload, String token, Class<T> clazz) throws ServiceException {
        return RequestUtils.execute(url, payload, token, null, clazz);
    }

    /**
     * Requisição anônima
     *
     * @param url
     * @param payload
     * @param tenant
     * @param clazz
     * @param <T>
     * @return
     * @throws ServiceException
     */
    protected <T> T executeAnonymous(String url, Object payload, String tenant, Class<T> clazz) throws ServiceException {
        return RequestUtils.execute(url, payload, null, tenant, clazz);
    }

    /**
     * Monta URL para as requisições actions
     *
     * @param path
     * @return
     */
    protected String getActionsUrl(String path) {
        return String.format("%s/rest/%s/%s/actions/%s", env.getUrl(), domain, service, path);
    }

    /**
     * Monta URL para as requisições queries
     *
     * @param path
     * @return
     */
    protected String getQueriesUrl(String path) {
        return String.format("%s/rest/%s/%s/queries/%s", env.getUrl(), domain, service, path);
    }

    /**
     * Monta URL para as requisições anônimas
     *
     * @param path
     * @return
     */
    protected String getAnonymousActionsUrl(String path) {
        return String.format("%s/anonymous/rest/%s/%s/actions/%s", env.getUrl(), domain, service, path);
    }

}
