package br.com.senior.core.authorization;

import br.com.senior.core.BaseIT;
import br.com.senior.core.authentication.AuthenticationClient;
import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.authorization.pojos.*;
import br.com.senior.core.utils.ServiceException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AuthorizationIT extends BaseIT {

    private static final String URI = "res://tenant/dominio/servico/recurso";
    private static final String ROLE_NAME = "PapelParaTestes";
    private static String token;

    @BeforeClass
    public static void beforeClass() throws ServiceException {
        token = new AuthenticationClient().login(new LoginInput(System.getenv("username"), System.getenv("password_valid"))).getJsonToken().getAccess_token();
    }

    @Test
    public void testCheckAccess() throws ServiceException {
        AuthorizationClient client = new AuthorizationClient(token);
        final String action = "Visualizar";
        final String resource = "res://senior.com.br/security/usermanager/usuario";
        final boolean includeFilters = false;
        final boolean includeDelegations = false;
        CheckAccessInput input = new CheckAccessInput(Collections.singletonList(new PermissionToCheck(resource, action)), includeFilters, includeDelegations);
        CheckAccessOutput output = client.checkAccess(input);
        Assert.assertTrue(output.getAuthorized());
    }

    @Test
    public void testSaveAndGetResources() throws ServiceException {
        GetResourcesOutput resources = getResources();
        Assert.assertEquals(0, resources.getResources().size());
        try {
            SaveResourcesOutput saved = saveResource();
            Assert.assertEquals(1, saved.getResources().size());
            resources = getResources();
            Assert.assertEquals(1, resources.getResources().size());
        } finally {
            deleteResource();
        }
    }

    @Test
    public void testSaveAndDeleteResources() throws ServiceException {
        GetResourcesOutput resources = getResources();
        Assert.assertEquals(0, resources.getResources().size());
        try {
            saveResource();
        } finally {
            deleteResource();
        }
        resources = getResources();
        Assert.assertEquals(0, resources.getResources().size());
    }

    @Test
    public void testCreateAndGetRole() throws ServiceException {
        Assert.assertThrows(ServiceException.class, this::getRole);
        try {
            Assert.assertNotNull(createRole());
            Assert.assertNotNull(getRole());
        } finally {
            deleteRole();
        }
    }

    @Test
    public void testCreateAndDeleteRoles() throws ServiceException {
        Assert.assertThrows(ServiceException.class, this::getRole);
        try {
            Assert.assertNotNull(createRole());
        } finally {
            Assert.assertNotNull(deleteRole());
        }
        Assert.assertThrows(ServiceException.class, this::getRole);
    }

    @Test
    public void testAssignUsers() throws ServiceException {
        try {
            Assert.assertNotNull(createRole());
            Assert.assertEquals(0, getAssignedUsers().users.size());
            assignUsers();
            Assert.assertEquals(1, getAssignedUsers().users.size());
        } finally {
            Assert.assertNotNull(deleteRole());
        }
    }

    @Test
    public void testUnAssignUsers() throws ServiceException {
        try {
            Assert.assertNotNull(createRole());
            assignUsers();
            Assert.assertEquals(1, getAssignedUsers().users.size());
            unassignUsers();
            Assert.assertEquals(0, getAssignedUsers().users.size());
        } finally {
            Assert.assertNotNull(deleteRole());
        }
    }

    private SaveResourcesOutput saveResource() throws ServiceException {
        List<Action> actions = Arrays.asList(new Action("Visualizar"), new Action("Editar"));
        SaveResourcesInput input = new SaveResourcesInput(Collections.singletonList(new Resource("recurso", URI, actions)));
        return new AuthorizationClient(token).saveResources(input);
    }

    private void deleteResource() throws ServiceException {
        DeleteResourcesInput input = new DeleteResourcesInput(Collections.singletonList(URI));
        new AuthorizationClient(token).deleteResources(input);
    }

    private GetResourcesOutput getResources() throws ServiceException {
        GetResourcesInput input = new GetResourcesInput(Collections.singletonList(URI));
        return new AuthorizationClient(token).getResource(input);
    }

    private GetRoleOutput getRole() throws ServiceException {
        GetRoleInput input = new GetRoleInput(ROLE_NAME);
        return new AuthorizationClient(token).getRole(input);
    }

    private CreateRoleOutput createRole() throws ServiceException {
        CreateRoleInput input = new CreateRoleInput(ROLE_NAME, "papel para testes de integração");
        return new AuthorizationClient(token).createRole(input);
    }

    private DeleteRoleOutput deleteRole() throws ServiceException {
        DeleteRoleInput input = new DeleteRoleInput(ROLE_NAME);
        return new AuthorizationClient(token).deleteRole(input);
    }

    private void unassignUsers() throws ServiceException {
        UnassignUsersInput input = new UnassignUsersInput(Collections.singletonList(ROLE_NAME), Collections.singletonList(System.getenv("OTHER_USER")));
        new AuthorizationClient(token).unassignUsers(input);
    }

    private void assignUsers() throws ServiceException {
        AssignUsersInput input = new AssignUsersInput(Collections.singletonList(ROLE_NAME), Collections.singletonList(System.getenv("OTHER_USER")));
        new AuthorizationClient(token).assignUsers(input);
    }

    private GetAssignedUsersOutput getAssignedUsers() throws ServiceException {
        GetAssignedUsersInput input = new GetAssignedUsersInput(Collections.singletonList(ROLE_NAME));
        return new AuthorizationClient(token).getAssignedUsers(input);
    }
}