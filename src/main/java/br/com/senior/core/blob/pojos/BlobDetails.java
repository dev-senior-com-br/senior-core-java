package br.com.senior.core.blob.pojos;

import lombok.Data;

@Data
public class BlobDetails {
    private String domainName;
    private String serviceName;
    private String targetObjectId;
    private String version;
    private String token;
    private String areaSecret;
    private Location location;
    private String fileName;
}
