package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.user.UserClient#createGroup(CreateGroupInput) createGroup}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateGroupInput {

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
     * Lista de usuários a serem associados ao grupo
     */
    public java.util.List<String> users;

}
