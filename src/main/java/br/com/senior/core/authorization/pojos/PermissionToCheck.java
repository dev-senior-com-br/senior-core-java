package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Conjunto de recurso, ação e atributos para validação da permissão
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
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

    /**
     * Construtor
     *
     * @param resource
     * @param action
     */
    public PermissionToCheck(String resource, String action) {
        this.resource = resource;
        this.action = action;
    }

}
