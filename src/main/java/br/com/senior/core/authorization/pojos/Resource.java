package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Um recurso é um elemento que deve ter seu acesso controlado pelo serviço de autorização
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Resource {

    /**
     * O identificador único do recurso, seguindo o padrão para novos recursos: res://dominio_tenant/custom/nome_servico/nome_recurso
     */
    String uri;
    /**
     * Nome do recurso
     */
    String name;
    /**
     * Chave de tradução para o nome do recurso
     */
    String label;
    /**
     * Chave de tradução para a descrição do recurso
     */
    String description;
    /**
     * As ações associadas ao recurso
     */
    List<Action> actions;
    /**
     * Domínio pertencente do recurso
     */
    String domainName;
    /**
     * Serviço pertencente do recurso
     */
    String serviceName;

    /**
     * Construtor
     *
     * @param name
     * @param uri
     * @param actions
     */
    public Resource(String name, String uri, List<Action> actions) {
        this.name = name;
        this.uri = uri;
        this.actions = actions;
    }
}
