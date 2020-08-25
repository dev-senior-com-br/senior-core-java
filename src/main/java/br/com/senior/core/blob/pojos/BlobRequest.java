package br.com.senior.core.blob.pojos;

import lombok.Data;

/**
 * Represents the input to request upload the blob operations
 */
@Data
public class BlobRequest {
    /**
     * Uma string com o nome do domínio
     */
    private String domainName;
    /**
     * Nome do serviço que esta enviando o arquivo
     */
    private String serviceName;
    /**
     * Nome da pasta ou área de armazenamento
     */
    private String areaSecret;
    /**
     * Identificador do arquivo no serviço onde é utilizado
     */
    private String targetObjectId;
    /**
     * Nome do arquivo
     */
    private String fileName;
}
