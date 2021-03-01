package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

/**
 * Uma ação de um recurso
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Action {

    /**
     * Nome da ação
     */
    String name;
    /**
     * Chave de tradução para o nome da ação
     */
    String label;
    /**
     * Indica se a ação pode ser somente utilizada por tenants master
     */
    boolean master;
    /**
     * Informação se a ação possui atributos, somente consulta
     */
    boolean hasAttributes;
    /**
     * Informa se a ação está bloqueada
     */
    boolean locked;

}
