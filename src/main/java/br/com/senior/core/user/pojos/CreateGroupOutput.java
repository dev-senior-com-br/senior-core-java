package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.user.UserClient#createGroup(CreateGroupInput) createGroup}
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateGroupOutput {

    /**
     * Identificador do grupo que foi inserido na base
     */
    public String id;

}
