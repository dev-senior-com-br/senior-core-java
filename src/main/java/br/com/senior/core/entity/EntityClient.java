package br.com.senior.core.entity;

import br.com.senior.core.base.Environment;
import br.com.senior.core.base.HttpMethod;
import br.com.senior.core.base.RequestUtils;
import br.com.senior.core.base.ServiceException;

import java.lang.reflect.Type;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class EntityClient<T> {

    private Environment env;
    private String domain;
    private String service;
    private String token;
    private Class<T> clazz;

    public EntityClient(Environment env, String domain, String service, String token, Class<T> clazz) {
        this.env = env;
        this.domain = domain;
        this.service = service;
        this.token = token;
        this.clazz = clazz;
    }

    public EntityClient(String domain, String service, String token, Class<T> clazz) {
        this.env = Environment.HOMOLOG;
        this.domain = domain;
        this.service = service;
        this.token = token;
        this.clazz = clazz;
    }

    public EntityPage<T> get(String entityName) throws ServiceException {
        return getWithFilter(entityName, null);
    }

    public EntityPage<T> getWithFilter(String entityName, String filter) throws ServiceException {
        EntityPage<T> execute = RequestUtils.execute(getUrl(entityName, null, filter), null, token, null, EntityPage.class, HttpMethod.GET);

        Gson gson = new Gson();
        JsonElement json = gson.toJsonTree(execute.getContents());
        Type type = new TypeToken<List<T>>() {}.getType();

        List<T> list = gson.fromJson(json, type);

        return new EntityPage<T>(execute.getTotalPages(), execute.getTotalElements(), list);
    }

    public T getById(String entityName, String id) throws ServiceException {
        return RequestUtils.execute(getUrl(entityName, id, null), null, token, null, clazz, HttpMethod.GET);
    }

    public T post(String entityName, T payload) throws ServiceException {
        return RequestUtils.execute(getUrl(entityName, null, null), payload, token, null, clazz, HttpMethod.POST);
    }

    public T put(String entityName, String id, T payload) throws ServiceException {
        return RequestUtils.execute(getUrl(entityName, id, null), payload, token, null, clazz, HttpMethod.PUT);
    }

    public void delete(String entityName, String id) throws ServiceException {
        RequestUtils.execute(getUrl(entityName, id, null), null, token, null, clazz, HttpMethod.DELETE);
    }

    private String getUrl(String entityName, String id, String filter) {
        String format = Environment.HOMOLOG.equals(env) ? "%s/rest/%s/%s/entities/%s" : "%s/%s/%s/entities/%s";
        String url = String.format(format, env.getUrl(), domain, service, entityName);
        if (id != null) {
            return url + "/" + id;
        } else {
            return filter == null ? url : url + filter;
        }
    }
}
