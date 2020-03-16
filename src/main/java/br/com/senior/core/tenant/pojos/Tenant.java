package br.com.senior.core.tenant.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tenant {
    String name;
    String domain;
    boolean active;
    boolean master;
    String locale;
    boolean ready;
    String[] altDomains;
}