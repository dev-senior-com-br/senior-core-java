package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.authorization.AuthorizationClient#saveResources(SaveResourcesInput) saveResources}
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class SaveResourcesInput {

    /**
     * Recursos que devem ser criados.
     * É possível utilizar o registro ownerResource para criar um recurso com um usuário como proprietário, informando o nome do usuário.
     */
    List<Resource> resources;

}
