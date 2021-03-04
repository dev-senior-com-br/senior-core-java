package br.com.senior.core.blob.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

/**
 * Represents the input to request upload the blob operations
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UploadFileInput {
    /**
     * Uma string com o nome do domínio
     */
    String domainName;
    /**
     * Nome do serviço que esta enviando o arquivo
     */
    String serviceName;
    /**
     * Nome da pasta ou área de armazenamento
     */
    String areaSecret;
    /**
     * Identificador do arquivo no serviço onde é utilizado
     */
    String targetObjectId;
    /**
     * Nome do arquivo
     */
    String fileName;

    public String getAreaSecret() {
        return areaSecret;
    }
}
