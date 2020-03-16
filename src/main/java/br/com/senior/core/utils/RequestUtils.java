package br.com.senior.core.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

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

/**
 * Utilitário para requisições HTTP
 */
@UtilityClass
@Slf4j
public class RequestUtils {

    /**
     * Executa a requisição
     *
     * @param url
     * @param payload
     * @param token
     * @param tenant
     * @param clazz
     * @param <T>
     * @return
     * @throws ServiceException
     */
    public static <T> T execute(String url, Object payload, String token, String tenant, Class<T> clazz) throws ServiceException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpResponse response = executePost(url, payload, client, token, tenant);
            return readResponse(response, clazz);
        } catch (IOException e) {
            throw new ServiceException("Erro ao efetuar requisição", e);
        }
    }

    /**
     * Executa a requisição POST
     *
     * @param url
     * @param payload
     * @param client
     * @param token
     * @param tenant
     * @return
     * @throws IOException
     */
    private HttpResponse executePost(String url, Object payload, CloseableHttpClient client, String token, String tenant) throws IOException {
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json");
        Optional.ofNullable(tenant).ifPresent(t -> post.setHeader("X-Tenant", t));
        Optional.ofNullable(token).ifPresent(t -> post.setHeader("Authorization", String.format("Bearer %s", t)));
        StringEntity userEntity = new StringEntity(new Gson().toJson(payload));
        post.setEntity(userEntity);
        return client.execute(post);
    }

    /**
     * Trata a resposta da requisição
     *
     * @param response
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     * @throws ServiceException
     */
    private <T> T readResponse(HttpResponse response, Class<T> clazz) throws IOException, ServiceException {
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode >= 400) {
            ErrorOutput errorOutput = new Gson().fromJson(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.ISO_8859_1), ErrorOutput.class);
            log.error("Erro ao efetuar requisição, código de erro: {}. Erro retornado: {}", statusCode, errorOutput);
            throw new ServiceException(statusCode, errorOutput.getMessage());
        }
        return new Gson().fromJson(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.ISO_8859_1), clazz);
    }
}
