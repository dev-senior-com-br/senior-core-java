package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveResourcesInput {

    /**
     * Recursos que devem ser criados.
     * É possível utilizar o registro ownerResource para criar um recurso com um usuário como proprietário, informando o nome do usuário.
     */
    List<Resource> resources;

    public SaveResourcesInput() {
    }

    public SaveResourcesInput(List<Resource> resources) {
        this.resources = resources;
    }

}
