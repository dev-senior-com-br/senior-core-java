package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de saída do {@link br.com.senior.core.user.UserClient#getGroup(GetGroupInput) getGroup}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class GetGroupOutput {

    /**
     * Identificador do Grupo
     */
    String id;
    /**
     * Nome do Grupo
     */
    String name;
    /**
     * Descrição do Grupo
     */
    String description;
    /**
     * E-mail do grupo
     */
    String email;
    /**
     * Informações básicas dos usuários do grupo
     */
    List<GroupBasicUser> users;

}
