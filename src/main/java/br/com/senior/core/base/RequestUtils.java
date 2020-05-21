package br.com.senior.core.base;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Optional;


/**
 * Utilitário para requisições HTTP
 */
@UtilityClass
@Slf4j
public class RequestUtils {

    /**
     * Remove entidade da Plataforma.
     *
     * @param url   Endpoint.
     * @param token AccessToken de authenticação.
     * @throws ServiceException Caso serviço esteja fora ou HTTP Status Code de retorno seja diferente de 2xx.
     */
    public void delete(String url, String token) throws ServiceException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpResponse response = executeDelete(url, client, token);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode < 200 || statusCode > 207) {
                throw new ServiceException(statusCode, String.format("Error to remove Entity with HTTP Status code %s", statusCode));
            }
        } catch (IOException e) {
            throw new ServiceException("Erro ao efetuar requisição", e);
        }
    }

    /*
     * Executa a requisição
     *
     * @param url     - Url da requisição
     * @param payload - Payload de entrada
     * @param token   - Access-token de autenticação
     * @param tenant  - Tenant
     * @param clazz   - Classe de payload de saída
     * @param <T>     - Tipo de classe
     * @return - Payload de saída
     * @throws ServiceException - Erro tratado de serviço
     */
    public <T> T execute(String url, Object payload, String token, String tenant, Class<T> clazz) throws ServiceException {
        return execute(url, payload, token, tenant, clazz, HttpMethod.POST);
    }

    public static <T> T execute(String url, Object payload, String token, String tenant, Class<T> clazz, HttpMethod method) throws ServiceException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpResponse response = null;
            switch (method) {
                case GET:
                    response = executeGet(url, client, token);
                    break;
                case POST:
                    response = executePost(url, payload, client, token, tenant);
                    break;
                case PUT:
                    response = executePut(url, payload, client, token);
                    break;
                case DELETE:
                    response = executeDelete(url, client, token);
                    break;
            }
            return readResponse(response, clazz);
        } catch (IOException e) {
            throw new ServiceException("Erro ao efetuar requisição", e);
        }
    }

    /**
     * Executa a requisição POST
     *
     * @param url     - Url da requisição
     * @param payload - Payload de entrada
     * @param client  - Cliente http
     * @param token   - Access-token de autenticação
     * @param tenant  - Tenant
     * @return - Resposta http
     * @throws IOException - Erro de comunicação
     */
    private HttpResponse executePost(String url, Object payload, CloseableHttpClient client, String token, String tenant) throws IOException {
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json");
        Optional.ofNullable(tenant).ifPresent(t -> post.setHeader("X-Tenant", t));
        Optional.ofNullable(token).ifPresent(t -> post.setHeader("Authorization", String.format("Bearer %s", t)));
        StringEntity userEntity = new StringEntity(SeniorGsonBuilder.newGsonBuilder().toJson(payload));
        post.setEntity(userEntity);
        return client.execute(post);
    }

    /**
     * Trata a resposta da requisição
     *
     * @param response - Resposta http
     * @param clazz    - Classe de payload de saída
     * @param <T>-     Tipo de classe
     * @return - Resposta em json
     * @throws IOException      - Erro de comunicação
     * @throws ServiceException - Erro tratado de serviço
     */
    private <T> T readResponse(HttpResponse response, Class<T> clazz) throws IOException, ServiceException {
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode >= 400) {
            String body = EntityUtils.toString(response.getEntity());
            throw new ServiceException(statusCode, body);
        }
        if (statusCode == 204 && response.getEntity() == null) {
            return null;
        }
        return SeniorGsonBuilder.newGsonBuilder().fromJson(new InputStreamReader(response.getEntity().getContent(), StandardCharsets.ISO_8859_1), clazz);
    }

    /**
     * Executa requisição HTTP com metodo DELETE.
     *
     * @param url    Enpoint.
     * @param client Cliente HTTP.
     * @param token  Access Token obtido na authenticação.
     * @return Resposta HTTP.
     * @throws IOException Erro de comunicação
     */
    private HttpResponse executeDelete(String url, CloseableHttpClient client, String token) throws IOException {
        HttpDelete delete = new HttpDelete(url);
        delete.setHeader("Content-Type", "application/json");
        Optional.ofNullable(token).ifPresent(t -> delete.setHeader("Authorization", String.format("Bearer %s", t)));
        return client.execute(delete);
    }

    private static HttpResponse executeGet(String url, CloseableHttpClient client, String token) throws IOException {
        HttpGet get = new HttpGet(url);
        get.setHeader("Content-Type", "application/json");
        Optional.ofNullable(token).ifPresent(t -> get.setHeader("Authorization", String.format("Bearer %s", t)));

        return client.execute(get);
    }

    private static HttpResponse executePut(String url, Object payload, CloseableHttpClient client, String token) throws IOException {
        HttpPut put = new HttpPut(url);
        put.setHeader("Content-Type", "application/json");
        Optional.ofNullable(token).ifPresent(t -> put.setHeader("Authorization", String.format("Bearer %s", t)));
        StringEntity userEntity = new StringEntity(SeniorGsonBuilder.newGsonBuilder().toJson(payload));
        put.setEntity(userEntity);
        return client.execute(put);
    }
}
