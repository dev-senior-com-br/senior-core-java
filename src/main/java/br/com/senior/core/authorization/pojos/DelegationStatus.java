package br.com.senior.core.authorization.pojos;

/**
 * Tipos de Status de Delegação
 */
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
