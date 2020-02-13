package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetRoleInput {

    /**
     * O nome do papel
     */
    String name;

    public GetRoleInput() {
    }

    public GetRoleInput(String name) {
        this.name = name;
    }

}
