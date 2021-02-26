package br.com.senior.core.user;

import br.com.senior.core.BaseExample;
import br.com.senior.core.base.ServiceException;
import br.com.senior.core.user.pojos.CreateGroupInput;
import br.com.senior.core.user.pojos.CreateGroupOutput;
import br.com.senior.core.user.pojos.CreateUserInput;
import br.com.senior.core.user.pojos.CreateUserOutput;
import br.com.senior.core.user.pojos.DeleteGroupInput;
import br.com.senior.core.user.pojos.DeleteUserInput;
import br.com.senior.core.user.pojos.GetGroupInput;
import br.com.senior.core.user.pojos.GetGroupOutput;
import br.com.senior.core.user.pojos.GetUserInput;
import br.com.senior.core.user.pojos.GetUserOutput;
import br.com.senior.core.user.pojos.GroupBasicUser;
import br.com.senior.core.user.pojos.ListGroupUsersInput;
import br.com.senior.core.user.pojos.ListGroupUsersOutput;
import br.com.senior.core.user.pojos.ListGroupsInput;
import br.com.senior.core.user.pojos.ListGroupsOutput;
import br.com.senior.core.user.pojos.UpdateGroupInput;
import br.com.senior.core.user.pojos.UpdateGroupOutput;
import br.com.senior.core.user.pojos.UpdateGroupUsersInput;
import br.com.senior.core.user.pojos.UpdateUserInput;
import br.com.senior.core.user.pojos.UpdateUserOutput;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Exemplos de código do Serviço User
 */
public class UserExample extends BaseExample {

    private static final String USER_NAME = "teste";
    private static final String USER_EMAIL = "teste@test.com.br";
    private static final String GROUP_NAME = "GrupoParaTestes";

    private static UserClient client;

    /**
     * Utilizando o {@link br.com.senior.core.user.UserClient UserClient}
     *
     * @param args - Argumentos de linha de comando
     * @throws ServiceException - Erro tratado de serviço
     */
    public static void main(String[] args) throws ServiceException {

        // Login
        String accessToken = getAccessToken();

        client = new UserClient(accessToken);


        // CreateUser
        CreateUserInput createUserInput = CreateUserInput.builder()
                .username(USER_NAME)
                .email(USER_EMAIL)
                .fullName("Nome Completo")
                .password("SuaSenha123")
                .changePassword(false)
                .blocked(false)
                .build();
        CreateUserOutput createUserOutput = client.createUser(createUserInput);

        System.out.println("CreateUser: " + createUserOutput.getUsername());


        // UpdateUser
        UpdateUserInput updateUserInput = UpdateUserInput.builder()
                .username(USER_NAME)
                .fullName("Nome Completo Atualizado")
                .changePassword(false)
                .blocked(false)
                .build();
        UpdateUserOutput updateUserOutput = client.updateUser(updateUserInput);

        System.out.println("UpdateUser: " + updateUserOutput.getUsername());


        // GetUser
        GetUserInput getUserInput = GetUserInput.builder()
                .username(USER_NAME)
                .build();
        GetUserOutput getUserOutput = client.getUser(getUserInput);

        System.out.println("GetUser: " + getUserOutput.getFullName());


        // CreateGroup
        List<String> users = List.of(USER_NAME);

        CreateGroupInput createGroupInput = CreateGroupInput.builder()
                .name(GROUP_NAME)
                .description("Descricao do Grupo " + GROUP_NAME)
                .email(USER_EMAIL)
                .users(users)
                .build();
        CreateGroupOutput createGroupOutput = client.createGroup(createGroupInput);

        String groupId = createGroupOutput.id;
        System.out.println("CreateGroup: " + groupId);


        // UpdateGroup
        UpdateGroupInput updateGroupInput = UpdateGroupInput.builder()
                .id(groupId)
                .name(GROUP_NAME)
                .description("Nova Descricao do Grupo " + GROUP_NAME)
                .email(USER_EMAIL)
                .build();
        UpdateGroupOutput updateGroupOutput = client.updateGroup(updateGroupInput);

        System.out.println("UpdateGroup: " + updateGroupOutput.id);


        // GetGroup
        GetGroupInput getGroupInput = GetGroupInput.builder()
                .id(groupId)
                .build();
        GetGroupOutput getGroupOutput = client.getGroup(getGroupInput);

        System.out.println("GetGroup: " + getGroupOutput.name + " - " + getGroupOutput.description);


        // ListGroups
        ListGroupsInput listGroupsInput = ListGroupsInput.builder()
                .searchValue(GROUP_NAME)
                .build();
        ListGroupsOutput listGroupsOutput = client.listGroups(listGroupsInput);

        System.out.println("ListGroups: " + String.join(", ",
                listGroupsOutput.groups.stream()
                        .map(group -> group.getName() + " - " + group.getDescription())
                        .collect(toList())));


        // ListGroupUsers
        ListGroupUsersInput input = ListGroupUsersInput.builder()
                .id(groupId)
                .build();
        ListGroupUsersOutput listGroupUsersOutput = client.listGroupUsers(input);

        System.out.println("ListGroupUsers: " + listGroupUsersOutput.users
                .stream().map(GroupBasicUser::getUsername)
                .collect(toList()));


        // UpdateGroupUsers
        UpdateGroupUsersInput updateGroupUsersInput = UpdateGroupUsersInput.builder()
                .groupId(groupId)
                .usersToRemove(List.of(USER_NAME))
                .build();
        client.updateGroupUsers(updateGroupUsersInput);


        // DeleteGroup
        DeleteGroupInput deleteGroupInput = DeleteGroupInput.builder()
                .id(groupId)
                .build();
        client.deleteGroup(deleteGroupInput);


        // DeleteUser
        DeleteUserInput deleteUserInput = DeleteUserInput.builder()
                .username(USER_NAME)
                .build();
        client.deleteUser(deleteUserInput);
    }

}