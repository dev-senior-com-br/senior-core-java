package br.com.senior.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;

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

    private String getUrl() {
        switch (env) {
            case PROD: return "https://platform.senior.com.br/t/senior.com.br/bridge/1.0/";
            case HOMOLOG: return "https://platform-homologx.senior.com.br/t/senior.com.br/bridge/1.0/";
            default: throw new IllegalStateException("Environment inválido");
        }
    }

    protected String execute(String url, Object payload) throws ServiceException {
        return execute(url, payload, null);
    }

    protected String execute(String url, Object payload, String token) throws ServiceException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpResponse response = executePost(url, payload, client, token);
            return readResponse(response);
        } catch (IOException e) {
            throw new ServiceException("Erro ao efetuar requisição", e);
        }
    }

    private HttpResponse executePost(String url, Object payload, CloseableHttpClient client, String token) throws IOException {
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json");
        Optional.ofNullable(token).ifPresent(t -> post.setHeader("Authorization", String.format("Bearer %s", t)));
        StringEntity userEntity = new StringEntity(new Gson().toJson(payload));
        post.setEntity(userEntity);
        return client.execute(post);
    }

    private String readResponse(HttpResponse response) throws IOException, ServiceException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.ISO_8859_1), 8);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        response.getEntity().getContent().close();
        int statusCode = response.getStatusLine().getStatusCode();
        switch(statusCode) {
            case 200: return sb.toString();
            case 401:
                log.error("Erro ao efetuar requisição, código de erro: {}. Erro retornado: {}", statusCode, sb);
                throw new ServiceException(statusCode, "Token inválido");
            default:
                log.error("Erro ao efetuar requisição, código de erro: {}. Erro retornado: {}", statusCode, sb);
                throw new ServiceException(statusCode, new Gson().fromJson(sb.toString(), ErrorOutput.class).getMessage());
        }
    }

    protected String getActionsUrl() {
        return String.format("%s/rest/%s/%s/actions/", getUrl(), this.domain, this.service);
    }

    protected String getAnonymousActionsUrl() {
        return String.format("%s/anonymous/rest/%s/%s/actions/", getUrl(), this.domain, this.service);
    }

}
