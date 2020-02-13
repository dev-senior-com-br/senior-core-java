package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateRoleInput {

    /**
     * O nome do papel
     */
    String name;
    /**
     * A descrição do papel
     */
    String description;

    public CreateRoleInput() {
    }

    public CreateRoleInput(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CreateRoleInput(String name) {
        this.name = name;
    }

}
