package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.user.UserClient#updateGroup(UpdateGroupInput) updateGroup}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGroupOutput {

    /**
     * Identificador do grupo que foi atualizado
     */
    String id;
}
