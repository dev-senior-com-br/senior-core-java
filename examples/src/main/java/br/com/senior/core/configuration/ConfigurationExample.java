package br.com.senior.core.configuration;

import br.com.senior.core.BaseExample;
import br.com.senior.core.base.ServiceException;
import br.com.senior.core.configuration.pojos.CustomPropertyValue;
import br.com.senior.core.configuration.pojos.DeleteCustomPropertyInput;
import br.com.senior.core.configuration.pojos.GetCustomPropertyInput;
import br.com.senior.core.configuration.pojos.PropertyLevel;
import br.com.senior.core.configuration.pojos.PropertyType;

import java.util.List;

/**
 * Exemplos de código do Serviço Configuration
 */
public class ConfigurationExample extends BaseExample {

    /**
     * Utilizando o {@link br.com.senior.core.configuration.ConfigurationClient ConfigurationClient}
     *
     * @param args - Argumentos de linha de comando
     * @throws ServiceException - Erro tratado de serviço
     */
    public static void main(String[] args) throws ServiceException {

        // Login
        String accessToken = getAccessToken();

        ConfigurationClient client = new ConfigurationClient(accessToken);


        // CreateCustomConfiguration
        CustomPropertyValue customPropertyValue = CustomPropertyValue.builder()
                .propertyKey("teste")
                .propertyValue("valor")
                .type(PropertyType.String)
                .label("label")
                .hashTags(List.of("teste", "exemplo"))
                .propertyLevel(PropertyLevel.INFRA)
                .build();
        client.createCustomConfiguration(customPropertyValue);


        // UpdateCustomConfiguration
        customPropertyValue = CustomPropertyValue.builder()
                .propertyKey("teste")
                .propertyValue("novo_valor")
                .type(PropertyType.String)
                .label("label")
                .hashTags(List.of("teste", "exemplo"))
                .propertyLevel(PropertyLevel.INFRA)
                .build();
        client.updateCustomConfiguration(customPropertyValue);


        // GetCustomConfiguration
        GetCustomPropertyInput getCustomPropertyInput = GetCustomPropertyInput.builder()
                .propertyKey("teste")
                .build();
        CustomPropertyValue propertyValue = client.getCustomConfiguration(getCustomPropertyInput);

        System.out.println("GetCustomConfiguration: " + propertyValue.getPropertyValue());


        // DeleteCustomProperty
        DeleteCustomPropertyInput deleteCustomPropertyInput = DeleteCustomPropertyInput.builder()
                .propertyKey("teste")
                .build();
        client.deleteCustomProperty(deleteCustomPropertyInput);
    }
}
