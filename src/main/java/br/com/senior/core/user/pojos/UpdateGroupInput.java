package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.List;

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
    String id;
    /**
     * Nome do grupo
     */
    @NonNull
    String name;
    /**
     * Descrição do grupo
     */
    String description;
    /**
     * E-mail do grupo
     */
    @NonNull
    String email;
    /**
     * Usuários a serem incluídos no grupo
     */
    List<String> usersToAdd;
    /**
     * Usuários a serem excluídos do grupo
     */
    List<String> usersToRemove;

}
