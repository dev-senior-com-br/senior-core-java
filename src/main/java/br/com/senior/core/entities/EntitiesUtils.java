package br.com.senior.core.entities;

import br.com.senior.core.base.Environment;
import br.com.senior.core.base.HttpMethod;
import br.com.senior.core.base.RequestUtils;
import br.com.senior.core.base.ServiceException;

public class EntitiesUtils<T> {

    Environment env;
    String domain;
    String service;
    String token;
    Class<T> clazz;

    public EntitiesUtils(Environment env, String domain, String service, String token, Class<T> clazz) {
        this.env = env;
        this.domain = domain;
        this.service = service;
        this.token = token;
        this.clazz = clazz;
    }

    public EntitiesUtils(String domain, String service, String token, Class<T> clazz) {
        this.env = Environment.HOMOLOG;
        this.domain = domain;
        this.service = service;
        this.token = token;
        this.clazz = clazz;
    }


    public EntityPage<T> executeGet(String entityName, String filter) {
        try {
            EntityPage<T> execute = RequestUtils.execute(getUrl(entityName, null, filter), null, token, null, EntityPage.class, HttpMethod.GET);
            execute.setClz(clazz);
            return execute;
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T executeGetById(String entityName, String id) {
        try {
            return RequestUtils.execute(getUrl(entityName, id, null), null, token, null, clazz, HttpMethod.GET);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T executePost(String entityName, T payload) {
        try {
            return RequestUtils.execute(getUrl(entityName, null, null), payload, token, null, clazz, HttpMethod.POST);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T executePut(String entityName, String id, T payload) {
        try {
            return RequestUtils.execute(getUrl(entityName, id, null), payload, token, null, clazz, HttpMethod.PUT);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void executeDelete(String entityName, String id) {
        try {
            RequestUtils.execute(getUrl(entityName, id, null), null, token, null, clazz, HttpMethod.DELETE);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    private String getUrl(String entityName, String id, String filter) {
        String url = String.format("%s/rest/%s/%s/entities/%s", env.getUrl(), domain, service, entityName);
        if (id != null) {
            return url + "/" + id;
        } else {
            return filter == null ? url : url + filter;
        }
    }
}
