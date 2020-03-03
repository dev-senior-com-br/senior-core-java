package br.com.senior.core.authentication.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenInternalOutput {

    /**
     * String contendo um json com os tokens de acesso, de refresh, o tempo de validade restante para o token de acesso e o nome do usuário
     */
    String jsonToken;

}
