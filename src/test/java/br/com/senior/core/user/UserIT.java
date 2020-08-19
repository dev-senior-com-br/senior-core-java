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
import br.com.senior.core.user.pojos.Pagination;
import br.com.senior.core.user.pojos.UpdateGroupInput;
import br.com.senior.core.user.pojos.UpdateGroupOutput;
import br.com.senior.core.user.pojos.UpdateGroupUsersInput;
import br.com.senior.core.user.pojos.UpdateGroupUsersOutput;
import br.com.senior.core.user.pojos.UpdateUserInput;
import br.com.senior.core.user.pojos.UpdateUserOutput;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Exemplos de código do {@link br.com.senior.core.user.UserClient UserClient}
 */
public class UserIT extends BaseIT {

    private static final String USER_NAME = "teste";
    private static final String USER_EMAIL = "teste@test.com.br";
    private static final String GROUP_NAME = "GrupoParaTestes";
    private static UserClient client;

    @BeforeClass
    public static void beforeClass() throws ServiceException {
        String token = login().getJsonToken().getAccess_token();
        client = new UserClient(token);
    }

    @Test
    public void testCreateAndGetGroup() throws ServiceException {
        String groupId = "";
        try {
            CreateGroupOutput createGroupOutput = createGroup();
            assertNotNull(createGroupOutput);
            groupId = createGroupOutput.getId();

            GetGroupOutput getGroupOutput = getGroup(groupId);
            assertNotNull(getGroupOutput);
        } finally {
            deleteGroup(groupId);
        }
    }

    @Test
    public void testCreateAndListGroups() throws ServiceException {
        String groupId = "";
        String userId = "";
        try {
            CreateUserOutput createUserOutput = createUser();
            assertNotNull(createUserOutput);
            userId = getUser().getId();

            CreateGroupOutput createGroupOutput = createGroup();
            assertNotNull(createGroupOutput);
            groupId = createGroupOutput.getId();

            ListGroupsOutput listGroupsOutput = listGroups();
            assertNotNull(listGroupsOutput);

            Assert.assertTrue(listGroupsOutput.groups.size() > 1);
        } finally {
            deleteUser(userId);
            deleteGroup(groupId);
        }
    }

    @Test
    public void testCreateAndListGroupUsers() throws ServiceException {
        String groupId = "";
        String userId = "";
        try {
            CreateUserOutput createUserOutput = createUser();
            assertNotNull(createUserOutput);

            GetUserOutput getUserOutput = getUser();
            assertNotNull(getUserOutput);
            userId = getUserOutput.getId();

            CreateGroupOutput createGroupOutput = createGroup(Arrays.asList(USER_NAME));
            assertNotNull(createGroupOutput);
            groupId = createGroupOutput.getId();

            ListGroupUsersOutput listGroupUsersOutput = listGroupUsers(groupId);
            assertNotNull(listGroupUsersOutput);
            Assert.assertEquals(1, listGroupUsersOutput.users.size());
        } finally {
            deleteUser(userId);
            deleteGroup(groupId);
        }
    }

    @Test
    public void testGetAndUpdateGroup() throws ServiceException {
        String groupId = "";
        try {
            CreateGroupOutput createGroupOutput = createGroup();
            assertNotNull(createGroupOutput);
            groupId = createGroupOutput.getId();

            GetGroupOutput getGroupOutput = getGroup(groupId);
            assertNotNull(getGroupOutput);

            UpdateGroupOutput updateGroupOutput = updateGroup(groupId);
            assertNotNull(updateGroupOutput);
        } finally {
            deleteGroup(groupId);
        }
    }

    @Test
    public void testGetAndUpdateGroupUsers() throws ServiceException {
        String groupId = "";
        String userId = "";

        try {
            CreateUserOutput createUserOutput = createUser();
            assertNotNull(createUserOutput);

            GetUserOutput getUserOutput = getUser();
            assertNotNull(getUserOutput);
            userId = getUserOutput.getId();

            CreateGroupOutput createGroupOutput = createGroup();
            assertNotNull(createGroupOutput);
            groupId = createGroupOutput.getId();

            GetGroupOutput getGroupOutput = getGroup(groupId);
            assertNotNull(getGroupOutput);

            UpdateGroupUsersOutput updateGroupUsersOutput = updateGroupUsers(groupId);
            assertNotNull(updateGroupUsersOutput);
        } finally {
            deleteUser(userId);
            deleteGroup(groupId);
        }
    }

    @Test
    public void testCreateAndGetUser() throws ServiceException {
        String userId = "";
        try {
            CreateUserOutput createUserOutput = createUser();
            assertNotNull(createUserOutput);

            GetUserOutput getUserOutput = getUser();
            assertNotNull(getUserOutput);
            userId = getUserOutput.getId();
        } finally {
            deleteUser(userId);
        }
    }

    @Test
    public void testGetAndUpdateUser() throws ServiceException {
        String userId = "";
        try {
            CreateUserOutput createUserOutput = createUser();
            assertNotNull(createUserOutput);

            GetUserOutput getUserOutput = getUser();
            assertNotNull(getUserOutput);
            userId = getUserOutput.getId();

            UpdateUserOutput updateUserOutput = updateUser();
            assertNotNull(updateUserOutput);
        } finally {
            deleteUser(userId);
        }
    }

    @Test(expected = ServiceException.class)
    public void testDeleteGroupException() throws ServiceException {
        String groupId = "XPTO1234";
        deleteGroup(groupId);
    }

    @Test
    public void testDeleteGroup() throws Exception {
        CreateGroupOutput createGroupOutput = createGroup();
        assertNotNull(createGroupOutput);
        String groupId = createGroupOutput.getId();

        try {
            deleteGroup(groupId);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void listGroupsWithPagination() throws Exception {
        List<CreateGroupOutput> groups = new ArrayList<>();
        try {
            groups = createGroups();
            assertEquals(4, groups.size());

            ListGroupsInput input = new ListGroupsInput();
            input.setSearchValue(GROUP_NAME);

            Pagination pagination = new Pagination();
            pagination.setPageNumber(0L);
            pagination.setPageSize(2L);

            input.setPagination(pagination);

            ListGroupsOutput output = client.listGroups(input);
            assertEquals(2, output.getGroups().size());
            assertTrue(output.listInformation.totalPages >= 2);
            assertTrue(output.listInformation.totalElements >= 4);
        } finally {
            for (CreateGroupOutput group : groups) {
                deleteGroup(group.getId());
            }
        }
    }

    private List<CreateGroupOutput> createGroups() throws ServiceException {
        List<CreateGroupOutput> groups = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            groups.add(createGroup(GROUP_NAME + i));
        }
        return groups;
    }

    private GetGroupOutput getGroup(String groupId) throws ServiceException {
        GetGroupInput input = new GetGroupInput(groupId);
        return client.getGroup(input);
    }

    private CreateGroupOutput createGroup(String groupName) throws ServiceException {
        CreateGroupInput input = CreateGroupInput.builder()
                .name(groupName)
                .description("Descricao do Grupo " + groupName)
                .email(USER_EMAIL)
                .build();

        return client.createGroup(input);
    }

    private CreateGroupOutput createGroup(List<String> users) throws ServiceException {
        if (users.isEmpty()) {
            users = null;
        }
        CreateGroupInput input = CreateGroupInput.builder()
                .name(GROUP_NAME)
                .description("Descricao do Grupo")
                .email(USER_EMAIL)
                .users(users)
                .build();
        return client.createGroup(input);
    }

    private CreateGroupOutput createGroup() throws ServiceException {
        return createGroup(Collections.emptyList());
    }

    private UpdateGroupOutput updateGroup(String groupId) throws ServiceException {
        UpdateGroupInput input = UpdateGroupInput.builder().id(groupId)
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

    private ListGroupUsersOutput listGroupUsers(String groupId) throws ServiceException {
        ListGroupUsersInput input = new ListGroupUsersInput(groupId);
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

    private UpdateGroupUsersOutput updateGroupUsers(String groupId) throws ServiceException {
        UpdateGroupUsersInput input = UpdateGroupUsersInput.builder()
                .groupId(groupId)
                .usersToAdd(List.of(USER_NAME))
                .build();

        return client.updateGroupUsers(input);
    }

    private static void deleteGroup(String groupId) throws ServiceException {
        if (null != groupId && !groupId.isEmpty()) {
            client.deleteGroup(groupId);
        }
    }

    private static void deleteUser(String userId) throws ServiceException {
        if (null != userId && !userId.isEmpty()) {
            client.deleteUser(userId);
        }
    }
}
