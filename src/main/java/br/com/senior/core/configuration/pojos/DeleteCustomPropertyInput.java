package br.com.senior.core.configuration.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeleteCustomPropertyInput {

    /**
     * Nome da propriedade
     */
    String propertyKey;

}
