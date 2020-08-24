package br.com.senior.core.blob.pojos;

import lombok.Data;

/**
 * Representa o output das operações de blob.
 */
@Data
public class BlobDetails {
    /**
     * Nome do domínio para solicitar a operação
     */
    private String domainName;
    /**
     * Nome do serviço para solicitar a operação
     */
    private String serviceName;
    /**
     * Identifica exclusivamente o objeto de destino em seu serviço
     */
    private String targetObjectId;
    /**
     * Se esta for uma cópia do blob real, qual versão ele realmente está?
     */
    private String version;
    /**
     * Um token secreto necessário para acessar um blob protegido
     */
    private String token;
    /**
     * O local onde o arquivo reside ou deveria residir
     */
    private Location location;
    /**
     * O nome real do arquivo permanente
     */
    private String fileName;

    private String areaSecret;

}
