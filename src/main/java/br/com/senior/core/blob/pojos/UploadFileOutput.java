package br.com.senior.core.blob.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Representa o output das operações de blob.
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class UploadFileOutput {
    /**
     * Nome do domínio para solicitar a operação
     */
    String domainName;
    /**
     * Nome do serviço para solicitar a operação
     */
    String serviceName;
    /**
     * Identifica exclusivamente o objeto de destino em seu serviço
     */
    String targetObjectId;
    /**
     * Se esta for uma cópia do blob real, qual versão ele realmente está?
     */
    String version;
    /**
     * Um token secreto necessário para acessar um blob protegido
     */
    String token;
    /**
     * O local onde o arquivo reside ou deveria residir
     */
    Location location;
    /**
     * O nome real do arquivo permanente
     */
    String fileName;

}
