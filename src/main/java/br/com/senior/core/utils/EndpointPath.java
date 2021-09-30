package br.com.senior.core.utils;

import lombok.experimental.UtilityClass;

/**
 * Utilitário com os caminhos dos serviços
 */
@UtilityClass
public class EndpointPath {

    /**
     * Caminhos do serviço Authentication
     */
    @UtilityClass
    public class Authentication {

        public final String LOGIN = "login";
        public final String LOGIN_MFA = "loginMFA";
        public final String LOGIN_WITH_KEY = "loginWithKey";
        public final String LOGOUT = "logout";
        public final String REFRESH_TOKEN = "refreshToken";
    }

    /**
     * Caminhos do serviço Authorization
     */
    @UtilityClass
    public class Authorization {

        public final String GET_RESOURCES = "getResources";
        public final String SAVE_RESOURCES = "saveResources";
        public final String DELETE_RESOURCES = "deleteResources";
        public final String GET_ROLE = "getRole";
        public final String CREATE_ROLE = "createRole";
        public final String GET_ROLE_FILTERS = "getRoleFilters";
        public final String DELETE_ROLE = "deleteRole";
        public final String GET_ASSIGN_USERS = "getAssignedUsers";
        public final String ASSIGN_USER = "assignUsers";
        public final String UNASSIGN_USER = "unassignUsers";
        public final String CHECK_ACCESS = "checkAccess";
        public final String LIST_ROLES = "listRoles";
    }

    /**
     * Caminhos do serviço Configuration
     */
    @UtilityClass
    public class Configuration {

        public final String GET_CUSTOM_PROPERTY = "getCustomProperty";
        public final String CREATE_CUSTOM_PROPERTY = "createCustomProperty";
        public final String UPDATE_CUSTOM_PROPERTY = "updateCustomProperty";
        public final String DELETE_CUSTOM_PROPERTY = "deleteCustomProperty";
        public final String LIST_SERVICE_PROPERTIES = "listServiceProperties";
    }

    /**
     * Caminhos do serviço User
     */
    @UtilityClass
    public class User {

        public final String GET_USER = "getUser";
        public final String CREATE_USER = "createUser";
        public final String UPDATE_USER = "updateUser";
        public final String GET_GROUP = "getGroup";
        public final String CREATE_GROUP = "createGroup";
        public final String UPDATE_GROUP = "updateGroup";
        public final String LIST_GROUPS = "listGroups";
        public final String LIST_GROUP_USERS = "listGroupUsers";
        public final String UPDATE_GROUP_USERS = "updateGroupUsers";
        public final String DELETE_GROUP = "removeGroup";
        public final String DELETE_USER = "deleteUser";
    }

    /**
     * Caminhos do serviço Tenant
     */
    @UtilityClass
    public class Tenant {

        public final String GET_TENANT_BY_DOMAIN = "getTenantByDomain";
        public final String GET_TENANT_BY_NAME = "getTenantByName";
    }

    /**
     * Caminhos do serviço Notification
     */
    @UtilityClass
    public class Notification {

        public final String NOTIFY_USER = "notifyUser";
    }

    /**
     * Caminhos do serviço Blob Service
     */
    @UtilityClass
    public class BlobService {
        public final String COMMIT_FILE = "commitFile";
        public final String UPLOAD_FILE = "uploadFile";
    }
}
