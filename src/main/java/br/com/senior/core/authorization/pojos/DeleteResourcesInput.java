package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeleteResourcesInput {

    /**
     * Identificadores dos recursos
     */
    List<String> resources;

    public DeleteResourcesInput() {
    }

    public DeleteResourcesInput(List<String> resources) {
        this.resources = resources;
    }
}
