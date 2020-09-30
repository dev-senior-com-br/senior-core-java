package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.user.UserClient#deleteGroup(DeleteGroupInput) deleteGroup}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DeleteGroupInput {

    /**
     * id do grupo
     */
    @NonNull
    public String id;

}
