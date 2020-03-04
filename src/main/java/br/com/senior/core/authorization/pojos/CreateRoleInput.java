package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoleInput {

    /**
     * O nome do papel
     */
    String name;
    /**
     * A descrição do papel
     */
    String description;

    public CreateRoleInput(String name) {
        this.name = name;
    }

}
