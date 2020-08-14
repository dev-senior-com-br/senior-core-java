package br.com.senior.core.user;

import br.com.senior.core.BaseIT;
import br.com.senior.core.base.ServiceException;
import br.com.senior.core.user.pojos.CreateGroupInput;
import br.com.senior.core.user.pojos.CreateGroupOutput;
import br.com.senior.core.user.pojos.CreateUserInput;
import br.com.senior.core.user.pojos.CreateUserOutput;
import br.com.senior.core.user.pojos.GetGroupInput;
import br.com.senior.core.user.pojos.GetGroupOutput;
import br.com.senior.core.user.pojos.GetUserInput;
import br.com.senior.core.user.pojos.GetUserOutput;
import br.com.senior.core.user.pojos.ListGroupUsersInput;
import br.com.senior.core.user.pojos.ListGroupUsersOutput;
import br.com.senior.core.user.pojos.ListGroupsInput;
import br.com.senior.core.user.pojos.ListGroupsOutput;
import br.com.senior.core.user.pojos.UpdateGroupInput;
import br.com.senior.core.user.pojos.UpdateGroupOutput;
import br.com.senior.core.user.pojos.UpdateGroupUsersInput;
import br.com.senior.core.user.pojos.UpdateGroupUsersOutput;
import br.com.senior.core.user.pojos.UpdateUserInput;
import br.com.senior.core.user.pojos.UpdateUserOutput;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Exemplos de código do {@link br.com.senior.core.user.UserClient UserClient}
 */
public class UserIT extends BaseIT {

    private static final String USER_NAME = "teste";
    private static final String USER_EMAIL = "teste@test.com.br";
    private static final String GROUP_NAME = "GrupoParaTestes";
    private static String USER_ID;
    private static String GROUP_ID;
    private static String token;
    private static UserClient client;

    @BeforeClass
    public static void beforeClass() throws ServiceException {
        token = login().getJsonToken().getAccess_token();
        client = new UserClient(token);
    }

    private static void deleteGroup() throws ServiceException {
        client.deleteGroup(GROUP_ID);
    }

    private static void deleteUser() throws ServiceException {
        client.deleteUser(USER_ID);
    }

    @Test
    public void testCreateAndGetGroup() throws ServiceException {
        try {
            CreateGroupOutput createGroupOutput = createGroup();
            assertNotNull(createGroupOutput);
            GROUP_ID = createGroupOutput.getId();

            GetGroupOutput getGroupOutput = getGroup();
            assertNotNull(getGroupOutput);
        } finally {
            deleteGroup();
        }
    }

    @Test
    public void testCreateAndListGroups() throws ServiceException {
        try {
            CreateUserOutput createUserOutput = createUser();
            assertNotNull(createUserOutput);
            USER_ID = getUser().getId();

            CreateGroupOutput createGroupOutput = createGroup();
            assertNotNull(createGroupOutput);
            GROUP_ID = createGroupOutput.getId();

            ListGroupsOutput listGroupsOutput = listGroups();
            assertNotNull(listGroupsOutput);
            Assert.assertEquals(9, listGroupsOutput.groups.size());
        } finally {
            deleteUser();
            deleteGroup();
        }

    }

    @Test
    public void testCreateAndListGroupUsers() throws ServiceException {
        try {
            CreateUserOutput createUserOutput = createUser();
            assertNotNull(createUserOutput);

            GetUserOutput getUserOutput = getUser();
            assertNotNull(getUserOutput);
            USER_ID = getUserOutput.getId();

            CreateGroupOutput createGroupOutput = createGroup();
            assertNotNull(createGroupOutput);
            GROUP_ID = createGroupOutput.getId();

            ListGroupUsersOutput listGroupUsersOutput = listGroupUsers();
            assertNotNull(listGroupUsersOutput);
            Assert.assertEquals(0, listGroupUsersOutput.users.size());
        } finally {
            deleteUser();
            deleteGroup();
        }
    }

    @Test
    public void testGetAndUpdateGroup() throws ServiceException {
        try {
            CreateGroupOutput createGroupOutput = createGroup();
            assertNotNull(createGroupOutput);
            GROUP_ID = createGroupOutput.getId();

            GetGroupOutput getGroupOutput = getGroup();
            assertNotNull(getGroupOutput);

            UpdateGroupOutput updateGroupOutput = updateGroup();
            assertNotNull(updateGroupOutput);
        } finally {
            deleteGroup();
        }
    }

    @Test
    public void testGetAndUpdateGroupUsers() throws ServiceException {
        try {
            CreateUserOutput createUserOutput = createUser();
            assertNotNull(createUserOutput);

            GetUserOutput getUserOutput = getUser();
            assertNotNull(getUserOutput);
            USER_ID = getUserOutput.getId();

            CreateGroupOutput createGroupOutput = createGroup();
            assertNotNull(createGroupOutput);
            GROUP_ID = createGroupOutput.getId();

            GetGroupOutput getGroupOutput = getGroup();
            assertNotNull(getGroupOutput);

            UpdateGroupUsersOutput updateGroupUsersOutput = updateGroupUsers();
            assertNotNull(updateGroupUsersOutput);
        } finally {
            deleteUser();
            deleteGroup();
        }
    }

    @Test
    public void testCreateAndGetUser() throws ServiceException {
        try {
            CreateUserOutput createUserOutput = createUser();
            assertNotNull(createUserOutput);

            GetUserOutput getUserOutput = getUser();
            assertNotNull(getUserOutput);
            USER_ID = getUserOutput.getId();
        } finally {
            deleteUser();
        }
    }

    @Test
    public void testGetAndUpdateUser() throws ServiceException {
        try {
            CreateUserOutput createUserOutput = createUser();
            assertNotNull(createUserOutput);

            GetUserOutput getUserOutput = getUser();
            assertNotNull(getUserOutput);
            USER_ID = getUserOutput.getId();

            UpdateUserOutput updateUserOutput = updateUser();
            assertNotNull(updateUserOutput);
        } finally {
            deleteUser();
        }
    }

    @Test(expected = Exception.class)
    public void testDeleteGroupException() throws ServiceException {
        GROUP_ID = "XPTO1234";
        deleteGroup();
    }

    @Test
    public void testDeleteGroup() throws Exception {
        CreateGroupOutput createGroupOutput = createGroup();
        assertNotNull(createGroupOutput);
        GROUP_ID = createGroupOutput.getId();

        try {
            deleteGroup();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    private GetGroupOutput getGroup() throws ServiceException {
        GetGroupInput input = new GetGroupInput(GROUP_ID);
        return client.getGroup(input);
    }

    private CreateGroupOutput createGroup() throws ServiceException {
        CreateGroupInput input = CreateGroupInput.builder()
                .name(GROUP_NAME)
                .description("Descricao do Grupo")
                .email(USER_EMAIL)
                .build();

        return client.createGroup(input);
    }

    private UpdateGroupOutput updateGroup() throws ServiceException {
        UpdateGroupInput input = UpdateGroupInput.builder().id(GROUP_ID)
                .name(GROUP_NAME)
                .description("Descricao do Grupo")
                .email(USER_EMAIL)
                .build();

        return client.updateGroup(input);
    }

    private ListGroupsOutput listGroups() throws ServiceException {
        ListGroupsInput input = new ListGroupsInput();
        return client.listGroups(input);
    }

    private ListGroupUsersOutput listGroupUsers() throws ServiceException {
        ListGroupUsersInput input = new ListGroupUsersInput(GROUP_ID);
        return client.listGroupUsers(input);
    }

    private GetUserOutput getUser() throws ServiceException {
        GetUserInput input = new GetUserInput(USER_NAME);
        return client.getUser(input);
    }

    private CreateUserOutput createUser() throws ServiceException {
        CreateUserInput input = CreateUserInput.builder()
                .username(USER_NAME)
                .email(USER_EMAIL)
                .fullName("nome completo")
                .password("SuaSenha123")
                .changePassword(false)
                .blocked(false)
                .build();

        return client.createUser(input);
    }

    private UpdateUserOutput updateUser() throws ServiceException {
        UpdateUserInput input = UpdateUserInput.builder()
                .username(USER_NAME)
                .fullName("nome completo")
                .changePassword(false)
                .blocked(false)
                .build();

        return client.updateUser(input);
    }

    private UpdateGroupUsersOutput updateGroupUsers() throws ServiceException {
        UpdateGroupUsersInput input = UpdateGroupUsersInput.builder()
                .groupId(GROUP_ID)
                .usersToAdd(List.of(USER_NAME))
                .build();

        return client.updateGroupUsers(input);
    }
}
