package br.com.senior.core.blob.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Cria uma nova área permanente, protegida pelo secret fornecido.
 */
@Data
@AllArgsConstructor
public class CreateAreaInput {
    /**
     * Nome do domínio
     */
    private String domainName;
    /**
     * Nome do serviço
     */
    private String serviceName;
    /**
     * Secret da área.
     */
    private String areaSecret;
}
