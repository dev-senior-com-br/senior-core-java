package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogoutInput {

    /**
     * Token de acesso que será invalidado.
     */
    String accessToken;

    public LogoutInput() {
    }

    public LogoutInput(String accessToken) {
        this.accessToken = accessToken;
    }

}
