package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Conjunto do atributo e valor a ser utilizado no ABAC da verificação de permissão
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AttributeValue {

    /**
     * Nome do atributo
     */
    String attribute;
    /**
     * Valor do atributo
     */
    String value;

    public AttributeValue() {
    }

    public AttributeValue(String attribute, String value) {
        this.attribute = attribute;
        this.value = value;
    }

}
