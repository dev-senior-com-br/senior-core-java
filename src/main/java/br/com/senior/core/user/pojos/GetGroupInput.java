package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.user.UserClient#getGroup(GetGroupInput) getGroup}
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetGroupInput {

    /**
     * Identificador do grupo
     */
    @NonNull
    public String id;

}
