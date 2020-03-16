package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.user.UserClient#updateUser(UpdateUserInput) updateUser}
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateUserOutput {

    /**
     * Nome do usuário que foi atualizado
     */
    public String username;
}
