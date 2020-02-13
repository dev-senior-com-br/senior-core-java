package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Uma ação de um recurso
 */
@Getter
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
    Boolean master;
    /**
     * Informação se a ação possui atributos, somente consulta
     */
    Boolean hasAttributes;
    /**
     * Informa se a ação está bloqueada
     */
    Boolean locked = false;

    public Action() {
    }

    public Action(String name, String label, Boolean master, Boolean hasAttributes, Boolean locked) {
        this.name = name;
        this.label = label;
        this.master = master;
        this.hasAttributes = hasAttributes;
        this.locked = locked;
    }

    public Action(String name) {
        this.name = name;
    }

}
