package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoleOutput {

    /**
     * Retorna o nome do papel criado, quem estiver adicionando o papel,
     * pode obter todos os dados pelo name
     */
    String name;

}
