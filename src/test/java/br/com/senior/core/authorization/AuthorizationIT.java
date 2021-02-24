package br.com.senior.core.authorization;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.com.senior.core.authorization.pojos.Action;
import br.com.senior.core.authorization.pojos.AssignUsersInput;
import br.com.senior.core.authorization.pojos.CheckAccessInput;
import br.com.senior.core.authorization.pojos.CheckAccessOutput;
import br.com.senior.core.authorization.pojos.CreateRoleInput;
import br.com.senior.core.authorization.pojos.CreateRoleOutput;
import br.com.senior.core.authorization.pojos.DeleteResourcesInput;
import br.com.senior.core.authorization.pojos.DeleteRoleInput;
import br.com.senior.core.authorization.pojos.DeleteRoleOutput;
import br.com.senior.core.authorization.pojos.GetAssignedUsersInput;
import br.com.senior.core.authorization.pojos.GetAssignedUsersOutput;
import br.com.senior.core.authorization.pojos.GetResourceInput;
import br.com.senior.core.authorization.pojos.GetResourceOutput;
import br.com.senior.core.authorization.pojos.GetRoleInput;
import br.com.senior.core.authorization.pojos.GetRoleOutput;
import br.com.senior.core.authorization.pojos.ListRolesInput;
import br.com.senior.core.authorization.pojos.ListRolesOutput;
import br.com.senior.core.authorization.pojos.PermissionToCheck;
import br.com.senior.core.authorization.pojos.Resource;
import br.com.senior.core.authorization.pojos.SaveResourcesInput;
import br.com.senior.core.authorization.pojos.SaveResourcesOutput;
import br.com.senior.core.authorization.pojos.UnassignUsersInput;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.senior.core.BaseIT;
import br.com.senior.core.base.ServiceException;

/**
 * Exemplos de código do {@link br.com.senior.core.authorization.AuthorizationClient AuthorizationClient}
 */
public class AuthorizationIT extends BaseIT {

    private static final String URI = "res://tenant/dominio/servico/recurso";
    private static final String ROLE_NAME = "PapelParaTestes";
    private static String token;

    @BeforeClass
    public static void beforeClass() throws ServiceException {
        token = login().getJsonToken().getAccessToken();
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
        GetResourceOutput resources = getResources();
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
        GetResourceOutput resources = getResources();
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
    public void testCreateAndListRoles() throws ServiceException {
        Assert.assertThrows(ServiceException.class, this::getRole);
        try {
            Assert.assertNotNull(createRole());
            Assert.assertNotNull(listRoles());
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

    private GetResourceOutput getResources() throws ServiceException {
        GetResourceInput input = new GetResourceInput(Collections.singletonList(URI));
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

    private ListRolesOutput listRoles() throws ServiceException {
        ListRolesInput input = new ListRolesInput();
        return new AuthorizationClient(token).listRoles(input);
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
