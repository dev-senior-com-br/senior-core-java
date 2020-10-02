package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.user.UserClient#deleteUser(DeleteUserInput) deleteUser}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeleteUserInput {

    /**
     * username do Usuário
     */
    @NonNull
    public String username;

}
