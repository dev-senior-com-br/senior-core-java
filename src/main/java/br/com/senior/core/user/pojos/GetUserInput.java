package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.user.UserClient#getUser(GetUserInput) getUser}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetUserInput {

    /**
     * Nome do usuário no formato nome@dominio_tenant
     */
    @NonNull
    String username;

}
