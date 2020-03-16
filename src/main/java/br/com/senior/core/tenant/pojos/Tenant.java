package br.com.senior.core.tenant.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Representa os dados de um tenant
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tenant {
    /**
     * Nome do tenant.
     */
    String name;
    /**
     * O domínio do tenant
     */
    String domain;
    /**
     * Indica se o tenant está ativo.
     */
    boolean active;
    /**
     * Indica se o tenant é master.
     */
    boolean master;
    /**
     * O locale do tenant
     */
    String locale;
    /**
     * Se todo o processamento de ativação foi realizado
     */
    boolean ready;
    /**
     * Lista de domínios alternativos do tenant
     */
    String[] altDomains;
}