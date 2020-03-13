package br.com.senior.core.utils;

import lombok.Getter;

@Getter
public enum EndpointPath {
    GET_TENANT_BY_DOMAIN("getTenantByDomain"),
    GET_TENANT_BY_NAME("getTenantByName"),
    LOGIN("login"),
    LOGIN_MFA("loginMFA"),
    LOGIN_WITH_KEY("loginWithKey"),
    LOGOUT("logout"),
    REFRESH_TOKEN("refreshToken"),
    CHECK_ACCESS("checkAccess"),
    SAVE_RESOURCES("saveResources"),
    DELETE_RESOURCES("deleteResources"),
    GET_RESOURCES("getResources"), CREATE_ROLE("createRole"),
    ASSIGN_USER("assignUsers"),
    UNASSIGN_USER("unassignUsers"),
    GET_ASSIGN_USERS("getAssignedUsers"),
    GET_ROLE("getRole"),
    DELETE_ROLE("deleteRole"),
    GET_USER("getUser");

    private final String pathName;

    EndpointPath(String pathName) {
        this.pathName = pathName;
    }
}
