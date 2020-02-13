package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Informaçoes básicas de uma atividade
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasicTask {

    /**
     * O identificador único da atividade, seguindo o padrão: task://tenantDomain/domainName/serviceName/taskName
     */
    String uri;
    /**
     * Dominio associada a atividade
     */
    String domain;
    /**
     * Serviço associado a atividade
     */
    String service;
    /**
     * Nome da atividade
     */
    String name;
    /**
     * Chave de internacionalização para o nome da atividade
     */
    String label;
    /**
     * Chave de internacionalização para a descrição da atividade
     */
    String description;

}
