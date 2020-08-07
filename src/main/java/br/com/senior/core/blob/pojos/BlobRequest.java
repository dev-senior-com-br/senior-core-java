package br.com.senior.core.blob.pojos;

import lombok.Data;

import java.util.List;

@Data
public class BlobRequest {
    private String domainName;
    private String serviceName;
    private String areaSecret;
    private String targetObjectId;
    private String fileName;
    private String version;
    private String token;
    private List<Requirement> requirements;
    private List<Protocol> supportedProtocols;
    private String style;
    private long ttl;


}
