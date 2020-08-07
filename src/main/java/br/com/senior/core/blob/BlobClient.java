package br.com.senior.core.blob;

import br.com.senior.core.base.*;
import br.com.senior.core.blob.pojos.*;
import br.com.senior.core.utils.EndpointPath;

import java.util.Collections;
import java.util.UUID;

public class BlobClient extends BaseClient {

    public static final String SERVICE_NAME = "core";
    public static final String DOMAIN_NAME = "sdk";
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

    public CreateAreaOutput createArea(CreateAreaInput input) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.BlobService.CREATE_AREA), input, token, CreateAreaOutput.class);
    }

    public BlobDetails requestUpload(BlobRequest input) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.BlobService.REQUEST_UPLOAD), input, token, BlobDetails.class);
    }

    public CommitFileOutput commitFile(CommitFileInput input) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.BlobService.COMMIT_FILE), input, token, CommitFileOutput.class);
    }

    public BlobDetails uploadFile(long ttl, String fileName, byte[] fileBytes) throws ServiceException {
        CreateAreaOutput createAreaOutput = createArea(new CreateAreaInput(DOMAIN_NAME, SERVICE_NAME, areaSecret));
        if (!createAreaOutput.isSuccess()) {
            return null;
        }
        BlobRequest input = new BlobRequest();
        input.setDomainName(DOMAIN_NAME);
        input.setTtl(ttl);
        input.setFileName(fileName);
        input.setServiceName(SERVICE_NAME);
        input.setTargetObjectId(UUID.randomUUID().toString());
        input.setRequirements(Collections.singletonList(Requirement.Open));
        input.setSupportedProtocols(Collections.singletonList(Protocol.HTTP));
        BlobDetails blobDetails = requestUpload(input);
        blobDetails.setAreaSecret(areaSecret);

        RequestUtils.execute(blobDetails.getLocation().getUri(), fileBytes, null, null, Object.class, HttpMethod.PUT);
        CommitFileInput commitFileInput = new CommitFileInput();
        commitFileInput.setAreaSecret(areaSecret);
        commitFileInput.setDomainName(DOMAIN_NAME);
        commitFileInput.setServiceName(SERVICE_NAME);
        commitFileInput.setTargetObject(blobDetails.getTargetObjectId());
        commitFileInput.setFileName(fileName);
        commitFileInput.setVersion(blobDetails.getVersion());
        commitFileInput.setRelease(true);
        commitFile(commitFileInput);
        return blobDetails;
    }
}
