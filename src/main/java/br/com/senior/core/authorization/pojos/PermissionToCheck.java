package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Conjunto de recurso, ação e atributos para validação da permissão
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionToCheck {

    /**
     * URI do recurso
     */
    String resource;
    /**
     * Ação do recurso
     */
    String action;
    /**
     * Atributos ABAC à serem utilizados no script (se houver)
     */
    List<AttributeValue> attributes;

    public PermissionToCheck() {
    }

    public PermissionToCheck(String resource, String action, List<AttributeValue> attributes) {
        this.resource = resource;
        this.action = action;
        this.attributes = attributes;
    }

    public PermissionToCheck(String resource, String action) {
        this.resource = resource;
        this.action = action;
    }


}
