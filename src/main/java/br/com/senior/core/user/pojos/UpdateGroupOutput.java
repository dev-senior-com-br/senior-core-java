package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.user.UserClient#updateGroup(UpdateGroupInput) updateGroup}
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateGroupOutput {

    /**
     * Identificador do grupo que foi atualizado
     */
    public String id;
}
