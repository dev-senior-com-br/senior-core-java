package br.com.senior.core.blob;

import br.com.senior.core.base.*;
import br.com.senior.core.blob.pojos.BlobDetails;
import br.com.senior.core.blob.pojos.BlobRequest;
import br.com.senior.core.blob.pojos.CommitFileInput;
import br.com.senior.core.blob.pojos.CommitFileOutput;
import br.com.senior.core.utils.EndpointPath;

import java.util.UUID;

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

    public BlobDetails uploadFile(BlobRequest input) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.BlobService.UPLOAD_FILE), input, token, BlobDetails.class);
    }

    public CommitFileOutput commitFile(CommitFileInput input) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.BlobService.COMMIT_FILE), input, token, CommitFileOutput.class);
    }

    public BlobDetails uploadAndCommitFile(BlobRequest blobRequest, byte[] fileBytes) throws ServiceException {
        BlobRequest input = new BlobRequest();
        input.setDomainName(blobRequest.getDomainName());
        input.setFileName(blobRequest.getFileName());
        input.setServiceName(blobRequest.getServiceName());
        input.setTargetObjectId(UUID.randomUUID().toString());

        BlobDetails blobDetails = uploadFile(input);
        blobDetails.setAreaSecret(blobDetails.getServiceName());

        RequestUtils.execute(blobDetails.getLocation().getUri(), fileBytes, null, null, Object.class, HttpMethod.PUT);
        CommitFileInput commitFileInput = new CommitFileInput();
        commitFileInput.setAreaSecret(blobDetails.getServiceName());
        commitFileInput.setDomainName(blobRequest.getDomainName());
        commitFileInput.setServiceName(blobRequest.getServiceName());
        commitFileInput.setTargetObject(blobDetails.getTargetObjectId());
        commitFileInput.setFileName(blobRequest.getFileName());
        commitFileInput.setVersion(blobDetails.getVersion());
        commitFileInput.setRelease(true);
        commitFile(commitFileInput);
        return blobDetails;
    }
}
