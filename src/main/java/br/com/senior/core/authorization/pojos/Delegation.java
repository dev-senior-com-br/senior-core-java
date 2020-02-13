package br.com.senior.core.authorization.pojos;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Todos os dados de uma delegação
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Delegation {

    /**
     * O identificador da delegação criada
     */
    String delegationId;
    /**
     * Descrição do motivo da delegação
     */
    String reason;
    /**
     * Informações da atividade originária dessa delegação
     */
    BasicTask task;
    /**
     * Usuário que realizou a delegação
     */
    String originUser;
    /**
     * Usuário que receberá a delegação
     */
    String targetUser;
    /**
     * Data de início da delegação. Ela deve ser anterior ou igual a data de término e deve ser igual ou maior que a data atual.
     */
    LocalDate from;
    /**
     * Data de término da delegação. Ela deve ser igual ou posterior a data de início.
     */
    LocalDate to;
    /**
     * Se a delegeção também inclui os filtros de serviço e recurso associados ao usuário de origem
     */
    Boolean includeFilters;
    /**
     * Data de criação
     */
    Date createdDate;
    /**
     * Data de exclusão
     */
    Date deletedDate;
    /**
     * As permissões da atividade que serão delegadas
     */
    List<Permission> permissions;
    /**
     * Status da delegação
     */
    DelegationStatus status;

}
