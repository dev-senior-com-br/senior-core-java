package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateRoleOutput {

    /**
     * Retorna o nome do papel criado, quem estiver adicionando o papel,
     * pode obter todos os dados pelo name
     */
    String name;

    public CreateRoleOutput() {
    }

    public CreateRoleOutput(String name) {
        this.name = name;
    }

}
