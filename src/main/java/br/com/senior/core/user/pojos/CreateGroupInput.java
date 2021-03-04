package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.List;

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
     * Lista de usuários a serem associados ao grupo
     */
    List<String> users;

}
