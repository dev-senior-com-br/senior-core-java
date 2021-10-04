package br.com.senior.core.configuration.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListServicePropertiesOutput {

    /**
     * Lista de resultados
     */
    private java.util.List<Property> propertyList;

}
