package br.com.senior.core.blob;

import br.com.senior.core.base.RequestUtils;
import br.com.senior.core.base.ServiceException;
import br.com.senior.core.blob.pojos.BlobDetails;
import br.com.senior.core.blob.pojos.BlobRequest;
import br.com.senior.core.blob.pojos.CommitFileOutput;
import br.com.senior.core.blob.pojos.Location;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
public class BlobClientTest {

    @Mock
    BlobClient blobClient;

    @Before
    public void before() throws ServiceException {
        when(blobClient.uploadAndCommitFile(any(), any())).thenCallRealMethod();
        when(blobClient.uploadFile(any())).then(a -> {
            BlobDetails blobDetails = new BlobDetails();
            blobDetails.setAreaSecret("testSecret");
            blobDetails.setFileName("fileName.txt");
            blobDetails.setTargetObjectId("123");
            blobDetails.setServiceName("testServiceName");
            blobDetails.setDomainName("testDomainName");
            blobDetails.setLocation(new Location());
            return blobDetails;
        });
        when(blobClient.commitFile(any())).then(a -> new CommitFileOutput());
    }

    @PrepareForTest({RequestUtils.class})
    @Test
    public void uploadFileTest() throws ServiceException {
        mockStatic(RequestUtils.class);

        BlobRequest blobRequest = new BlobRequest();
        blobRequest.setAreaSecret("testSecret");
        blobRequest.setFileName("fileName.txt");
        blobRequest.setTargetObjectId("123");
        blobRequest.setServiceName("testServiceName");
        blobRequest.setDomainName("testDomainName");
        BlobDetails blobDetails = blobClient.uploadAndCommitFile(blobRequest, new byte[]{});

        assertEquals(blobRequest.getDomainName(), blobDetails.getDomainName());
        assertEquals(blobRequest.getAreaSecret(), blobDetails.getAreaSecret());
        assertEquals(blobRequest.getFileName(), blobDetails.getFileName());
        assertEquals(blobRequest.getTargetObjectId(), blobDetails.getTargetObjectId());
        assertEquals(blobRequest.getServiceName(), blobDetails.getServiceName());
        verify(blobClient, times(1)).uploadFile(any());
        verify(blobClient, times(1)).commitFile(any());
    }

}
