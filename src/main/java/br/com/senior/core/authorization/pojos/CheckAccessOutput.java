package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.authorization.AuthorizationClient#checkAccess(CheckAccessInput) checkAccess}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
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
