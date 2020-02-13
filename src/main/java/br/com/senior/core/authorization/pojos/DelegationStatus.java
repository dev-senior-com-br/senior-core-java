package br.com.senior.core.authorization.pojos;

public enum DelegationStatus {
    /**
     * Delegação ativa
     */
    ACTIVE,
    /**
     * Delegação pendente
     */
    PENDING,
    /**
     * Delegação excluída
     */
    DELETED,
    /**
     * Delegação completada
     */
    COMPLETED
}
