package br.com.senior.core.authorization.pojos;

import br.com.senior.core.user.pojos.ListInformation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ListRolesOutput {

    /**
     * Os elementos retornados pela listagem
     */
    java.util.List<Role> roles;
    /**
     * Informações sobre os resultados da listagem
     */
    ListInformation listInformation;

}
