package br.com.senior.core.configuration.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Atributos da propriedade customizada
 */
@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomPropertyValue {

    /**
     * Nome da propriedade
     */
    String propertyKey;
    /**
     * Tipo do dado da propriedade
     */
    PropertyType type;
    /**
     * Valor da propriedade
     */
    String propertyValue;
    /**
     * HashTags para a tela de configuração
     */
    java.util.List<String> hashTags;
    /**
     * Descrição da propriedade na tela de configuração
     */
    String label;
    /**
     * Nível da propridade (SYSTEM/INFRA) - Informativo
     */
    PropertyLevel propertyLevel;
}
