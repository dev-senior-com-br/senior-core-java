package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Conjunto do atributo e valor a ser utilizado no ABAC da verificação de permissão
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class AttributeValue {

    /**
     * Nome do atributo
     */
    String attribute;
    /**
     * Valor do atributo
     */
    String value;

}
