package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.user.UserClient#updateGroup(UpdateGroupInput) updateGroup}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateGroupInput {

    /**
     * Identificador do grupo
     */
    @NonNull
    public String id;
    /**
     * Nome do grupo
     */
    @NonNull
    public String name;
    /**
     * Descrição do grupo
     */
    public String description;
    /**
     * E-mail do grupo
     */
    @NonNull
    public String email;
    /**
     * Usuários a serem incluídos no grupo
     */
    public java.util.List<String> usersToAdd;
    /**
     * Usuários a serem excluídos do grupo
     */
    public java.util.List<String> usersToRemove;

}
