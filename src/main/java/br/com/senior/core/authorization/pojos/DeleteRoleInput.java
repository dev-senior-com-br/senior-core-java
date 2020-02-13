package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeleteRoleInput {

    /**
     * Nome do papel a ser deletado
     */
    String name;

    public DeleteRoleInput() {
    }

    public DeleteRoleInput(String name) {
        this.name = name;
    }

}
