package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Um papel de usuário
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {

    /**
     * Nome único do papel
     */
    String name;
    /**
     * Descrição do papel
     */
    String description;

    public Role() {
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
