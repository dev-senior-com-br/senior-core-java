package br.com.senior.core.authorization.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetRoleFiltersInput {

    List<String> roles;

    String domainName;

    String serviceName;
}
