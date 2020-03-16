package br.com.senior.core.utils;

import lombok.experimental.UtilityClass;

/**
 * Utilitário com os caminhos dos serviços
 */
@UtilityClass
public class EndpointPath {

    /**
     * Caminhos do serviço de Autenticação
     */
    @UtilityClass
    public class Authentication {

        public static final String LOGIN = "login";
        public static final String LOGIN_MFA = "loginMFA";
        public static final String LOGIN_WITH_KEY = "loginWithKey";
        public static final String LOGOUT = "logout";
        public static final String REFRESH_TOKEN = "refreshToken";
    }

    /**
     * Caminhos do serviço de Autorização
     */
    @UtilityClass
    public class Authorization {

        public static final String GET_RESOURCES = "getResources";
        public static final String SAVE_RESOURCES = "saveResources";
        public static final String DELETE_RESOURCES = "deleteResources";
        public static final String GET_ROLE = "getRole";
        public static final String CREATE_ROLE = "createRole";
        public static final String DELETE_ROLE = "deleteRole";
        public static final String GET_ASSIGN_USERS = "getAssignedUsers";
        public static final String ASSIGN_USER = "assignUsers";
        public static final String UNASSIGN_USER = "unassignUsers";
        public static final String CHECK_ACCESS = "checkAccess";
    }

    /**
     * Caminhos do serviço de Usuário
     */
    @UtilityClass
    public class User {

        public static final String GET_USER = "getUser";
        public static final String CREATE_USER = "createUser";
        public static final String UPDATE_USER = "updateUser";
        public static final String GET_GROUP = "getGroup";
        public static final String CREATE_GROUP = "createGroup";
        public static final String UPDATE_GROUP = "updateGroup";
        public static final String LIST_GROUPS = "listGroups";
        public static final String LIST_GROUP_USERS = "listGroupUsers";
        public static final String UPDATE_GROUP_USERS = "updateGroupUsers";
    }

    /**
     * Caminhos do serviço de Inquilino
     */
    @UtilityClass
    public class Tenant {

        public static final String GET_TENANT_BY_DOMAIN = "getTenantByDomain";
        public static final String GET_TENANT_BY_NAME = "getTenantByName";
    }

    /**
     * Caminhos do serviço de Notificação
     */
    @UtilityClass
    public class Notification {

        public static final String NOTIFY_USER = "notifyUser";
    }

}
