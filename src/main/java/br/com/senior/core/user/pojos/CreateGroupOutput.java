package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.user.UserClient#createGroup(CreateGroupInput) createGroup}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CreateGroupOutput {

    /**
     * Identificador do grupo que foi inserido na base
     */
    String id;

}
