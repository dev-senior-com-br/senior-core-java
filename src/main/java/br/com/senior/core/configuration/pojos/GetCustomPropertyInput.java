package br.com.senior.core.configuration.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetCustomPropertyInput {
    /**
     * Nome da propriedade que deve ser retornada
     */
    String propertyKey;
}
