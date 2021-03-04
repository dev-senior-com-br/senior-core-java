package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de entrada do {@link br.com.senior.core.authorization.AuthorizationClient#saveResources(SaveResourcesInput) saveResources}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveResourcesInput {

    /**
     * Recursos que devem ser criados.
     * É possível utilizar o registro ownerResource para criar um recurso com um usuário como proprietário, informando o nome do usuário.
     */
    List<Resource> resources;

}
