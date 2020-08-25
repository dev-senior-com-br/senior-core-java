package br.com.senior.core.blob.pojos;

import lombok.Data;

import java.util.List;

@Data
public class CommitFileInput {
    private String domainName;
    private String serviceName;
    private String targetObject;
    private String version;
    private String areaSecret;
    private boolean release;
    private String fileName;
    private String defaultStyle;
    private List<String> styles;
    private boolean extractMetadata;
    private Integer cacheTimeToExpireInMonths;
}
