package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.user.UserClient#listGroups(ListGroupsInput) listGroups}
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ListGroupsOutput {

    /**
     * Lista de grupos
     */
    public java.util.List<Group> groups;
    /**
     * Informações sobre os resultados da listagem
     */
    public ListInformation listInformation;

}
