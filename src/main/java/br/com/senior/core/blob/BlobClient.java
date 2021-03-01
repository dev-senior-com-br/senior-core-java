package br.com.senior.core.blob;

import br.com.senior.core.base.BaseClient;
import br.com.senior.core.base.Environment;
import br.com.senior.core.base.HttpMethod;
import br.com.senior.core.base.RequestUtils;
import br.com.senior.core.base.ServiceException;
import br.com.senior.core.blob.pojos.CommitFileInput;
import br.com.senior.core.blob.pojos.CommitFileOutput;
import br.com.senior.core.blob.pojos.UploadFileInput;
import br.com.senior.core.blob.pojos.UploadFileOutput;
import br.com.senior.core.utils.EndpointPath;

public class BlobClient extends BaseClient {

    String token;
    String areaSecret;

    public BlobClient(String token, String tenant) {
        super("platform", "blob_service");
        this.token = token;
        this.areaSecret = "sdkCore" + tenant;
    }

    public BlobClient(String token, String tenant, Environment env) {
        super("platform", "blob_service", env);
        this.token = token;
        this.areaSecret = "sdkCore" + tenant;
    }

    private UploadFileOutput uploadFile(UploadFileInput input) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.BlobService.UPLOAD_FILE), input, token, UploadFileOutput.class);
    }

    private CommitFileOutput commitFile(CommitFileInput input) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.BlobService.COMMIT_FILE), input, token, CommitFileOutput.class);
    }

    public CommitFileOutput uploadAndCommitFile(UploadFileInput uploadFileInput, byte[] fileBytes) throws ServiceException {
        UploadFileOutput uploadFileOutput = uploadFile(uploadFileInput);

        RequestUtils.execute(uploadFileOutput.getLocation().getUri(), fileBytes, null, null, Object.class, HttpMethod.PUT);

        CommitFileInput commitFileInput = CommitFileInput.builder()
                .areaSecret(uploadFileInput.getAreaSecret())
                .domainName(uploadFileOutput.getDomainName())
                .serviceName(uploadFileOutput.getServiceName())
                .targetObject(uploadFileOutput.getTargetObjectId())
                .fileName(uploadFileOutput.getFileName())
                .version(uploadFileOutput.getVersion())
                .release(true)
                .build();

        return commitFile(commitFileInput);
    }
}
