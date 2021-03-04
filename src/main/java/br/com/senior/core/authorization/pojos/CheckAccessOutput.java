package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de saída do {@link br.com.senior.core.authorization.AuthorizationClient#checkAccess(CheckAccessInput) checkAccess}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CheckAccessOutput {

    /**
     * As permissões verificadas e seus filtros
     */
    List<CheckedPermission> permissions;
    /**
     * Verdadeiro se o usuário possuir permissão em todos os recursos informados
     */
    Boolean authorized;

}
