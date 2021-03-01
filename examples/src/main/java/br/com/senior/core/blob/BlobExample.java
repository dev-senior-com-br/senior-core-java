package br.com.senior.core.blob;

import br.com.senior.core.BaseExample;
import br.com.senior.core.base.ServiceException;
import br.com.senior.core.blob.pojos.CommitFileOutput;
import br.com.senior.core.blob.pojos.UploadFileInput;

import java.io.IOException;
import java.io.InputStream;

/**
 * Exemplos de código do Serviço Blob
 */
public class BlobExample extends BaseExample {

    /**
     * Utilizando o {@link br.com.senior.core.blob.BlobClient BlobClient}
     *
     * @param args - Argumentos de linha de comando
     * @throws ServiceException - Erro tratado de serviço
     */
    public static void main(String[] args) throws ServiceException, IOException {

        // Login
        String accessToken = getAccessToken();

        BlobClient client = new BlobClient(accessToken, System.getenv("TENANT_DOMAIN"));


        // UploadFile
        String areaSecret = "testSecret";
        InputStream inputStream = BlobExample.class.getResourceAsStream("/Example.txt");

        UploadFileInput uploadFileInput = UploadFileInput.builder()
                .areaSecret(areaSecret)
                .fileName("fileName.txt")
                .targetObjectId("123")
                .serviceName("testServiceName")
                .domainName("testDomainName")
                .build();


        // UploadAndCommitFile
        CommitFileOutput commitFileOutput = client.uploadAndCommitFile(uploadFileInput, inputStream.readAllBytes());

        System.out.println("UploadAndCommitFile: " + commitFileOutput.getLocation().getUri());
    }

}
