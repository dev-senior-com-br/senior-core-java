package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de entrada do {@link br.com.senior.core.user.UserClient#updateGroupUsers(UpdateGroupUsersInput) updateGroupUsers}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateGroupUsersInput {

    /**
     * Lista de usuários que serão incluídos
     */
    List<String> usersToAdd;
    /**
     * Lista de usuários que serão removidos
     */
    List<String> usersToRemove;
    /**
     * Identificador do Grupo
     */
    String groupId;
}
