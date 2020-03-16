package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateGroupUsersInput {

    /**
     * Lista de usuários que serão incluídos
     */
    public java.util.List<String> usersToAdd;
    /**
     * Lista de usuários que serão removidos
     */
    public java.util.List<String> usersToRemove;
    /**
     * Identificador do Grupo
     */
    public String groupId;
}
