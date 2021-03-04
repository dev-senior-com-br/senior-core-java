package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Conjunto de recurso, ação e atributos para validação da permissão
 */
@Builder
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

}
