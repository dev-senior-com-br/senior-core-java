package br.com.senior.core.blob.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateAreaInput {
    private String domainName;
    private String serviceName;
    private String areaSecret;
}
