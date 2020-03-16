package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.user.UserClient#getGroup(GetGroupInput) getGroup}
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetGroupOutput {

    /**
     * Identificador do Grupo
     */
    public String id;
    /**
     * Nome do Grupo
     */
    public String name;
    /**
     * Descrição do Grupo
     */
    public String description;
    /**
     * E-mail do grupo
     */
    public String email;

    /**
     * Informações básicas dos usuários do grupo
     */
    public java.util.List<GroupBasicUser> users;

}
