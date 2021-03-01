package br.com.senior.core.blob.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommitFileInput {
    String domainName;
    String serviceName;
    String targetObject;
    String version;
    String areaSecret;
    boolean release;
    String fileName;
    String defaultStyle;
    List<String> styles;
    boolean extractMetadata;
    Integer cacheTimeToExpireInMonths;
}
