package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Um recurso é um elemento que deve ter seu acesso controlado pelo serviço de autorização
 */
@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
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

}
