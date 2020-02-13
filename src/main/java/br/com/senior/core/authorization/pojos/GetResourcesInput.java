package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetResourcesInput {

    /**
     * Os identificadores únicos dos recursos
     */
    List<String> uris;

    public GetResourcesInput() {
    }

    public GetResourcesInput(List<String> uris) {
        this.uris = uris;
    }

}
