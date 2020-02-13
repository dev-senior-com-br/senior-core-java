package br.com.senior.core.authorization.pojos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Um conjunto de resource e ação
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Permission {

    /**
     * O uri do resource
     */
    String resource;
    /**
     * O nome da ação
     */
    String action;

}
