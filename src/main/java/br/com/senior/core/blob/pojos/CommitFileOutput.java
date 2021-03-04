package br.com.senior.core.blob.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CommitFileOutput {

    String domainName;
    String serviceName;
    String targetObject;
    Location location;

    // Metadata
    String name;
    Integer size;
    FileType type;
    String title;
    String contentType;

}
