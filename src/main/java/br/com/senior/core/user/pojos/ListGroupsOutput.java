package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de saída do {@link br.com.senior.core.user.UserClient#listGroups(ListGroupsInput) listGroups}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ListGroupsOutput {

    /**
     * Lista de grupos
     */
    List<Group> groups;
    /**
     * Informações sobre os resultados da listagem
     */
    ListInformation listInformation;

}
