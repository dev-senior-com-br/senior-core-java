package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.user.UserClient#getUser(GetUserInput) getUser}
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetUserInput {

    /**
     * "Nome do usuário no formato nome@dominio_tenant"
     */
    @NonNull
    String username;

    /**
     * Email do usuário
      */
    @NonNull
    String email;

}
