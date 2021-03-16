package br.com.senior.core.authorization;

import br.com.senior.core.BaseExample;
import br.com.senior.core.authorization.pojos.Action;
import br.com.senior.core.authorization.pojos.AssignUsersInput;
import br.com.senior.core.authorization.pojos.CheckAccessInput;
import br.com.senior.core.authorization.pojos.CheckAccessOutput;
import br.com.senior.core.authorization.pojos.CreateRoleInput;
import br.com.senior.core.authorization.pojos.CreateRoleOutput;
import br.com.senior.core.authorization.pojos.DeleteResourcesInput;
import br.com.senior.core.authorization.pojos.DeleteRoleInput;
import br.com.senior.core.authorization.pojos.GetAssignedUsersInput;
import br.com.senior.core.authorization.pojos.GetAssignedUsersOutput;
import br.com.senior.core.authorization.pojos.GetResourcesInput;
import br.com.senior.core.authorization.pojos.GetResourcesOutput;
import br.com.senior.core.authorization.pojos.GetRoleInput;
import br.com.senior.core.authorization.pojos.GetRoleOutput;
import br.com.senior.core.authorization.pojos.ListRolesInput;
import br.com.senior.core.authorization.pojos.ListRolesOutput;
import br.com.senior.core.authorization.pojos.PermissionToCheck;
import br.com.senior.core.authorization.pojos.Resource;
import br.com.senior.core.authorization.pojos.Role;
import br.com.senior.core.authorization.pojos.SaveResourcesInput;
import br.com.senior.core.authorization.pojos.SaveResourcesOutput;
import br.com.senior.core.authorization.pojos.UnassignUsersInput;
import br.com.senior.core.base.ServiceException;
import br.com.senior.core.user.pojos.Pagination;

import java.util.stream.Collectors;

import static java.util.List.of;

/**
 * Exemplos de código do Serviço Authorization
 */
public class AuthorizationExample extends BaseExample {

    private static final String RESOURCE_URI = "res://tenant/dominio/servico/recurso";
    private static final String ROLE_NAME = "PapelParaTestes";

    /**
     * Utilizando o {@link br.com.senior.core.authorization.AuthorizationClient AuthorizationClient}
     *
     * @param args - Argumentos de linha de comando
     * @throws ServiceException - Erro tratado de serviço
     */
    public static void main(String[] args) throws ServiceException {

        // Login
        String accessToken = getAccessToken();

        AuthorizationClient client = new AuthorizationClient(accessToken);


        // SaveResources
        Action view = Action.builder()
                .name("Visualizar")
                .build();
        Action edit = Action.builder()
                .name("Editar")
                .build();
        Resource resource = Resource.builder()
                .name("Recurso de Exemplo")
                .actions(of(view, edit))
                .uri(RESOURCE_URI)
                .build();

        SaveResourcesInput saveResourcesInput = SaveResourcesInput.builder()
                .resources(of(resource))
                .build();
        SaveResourcesOutput saveResourcesOutput = client.saveResources(saveResourcesInput);

        System.out.println("SaveResources: " + saveResourcesOutput.getResources()
                .stream().map(Resource::getUri)
                .collect(Collectors.joining(", ")));


        // GetResources
        GetResourcesInput getResourcesInput = GetResourcesInput.builder()
                .uris(of(RESOURCE_URI))
                .build();
        GetResourcesOutput getResourcesOutput = client.getResources(getResourcesInput);

        System.out.println("GetResources: " + getResourcesOutput.getResources()
                .stream().map(Resource::getUri)
                .collect(Collectors.joining(", ")));


        // DeleteResources
        DeleteResourcesInput deleteResourcesInput = DeleteResourcesInput.builder()
                .resources(of(RESOURCE_URI))
                .build();
        client.deleteResources(deleteResourcesInput);


        // CheckAccess
        PermissionToCheck permissionToCheck = PermissionToCheck.builder()
                .resource("res://senior.com.br/security/usermanager/usuario")
                .action("Visualizar")
                .build();

        CheckAccessInput checkAccessInput = CheckAccessInput.builder()
                .permissions(of(permissionToCheck))
                .includeDelegations(false)
                .includeFilters(false)
                .build();
        CheckAccessOutput checkAccessOutput = client.checkAccess(checkAccessInput);

        System.out.println("CheckAccess: " + checkAccessOutput.getAuthorized());


        // CreateRole
        CreateRoleInput createRoleInput = CreateRoleInput.builder()
                .name(ROLE_NAME)
                .description("papel para testes de integração")
                .build();
        CreateRoleOutput createRoleOutput = client.createRole(createRoleInput);

        System.out.println("CreateRole : " + createRoleOutput.getName());


        // GetRole
        GetRoleInput getRoleInput = GetRoleInput.builder()
                .name(ROLE_NAME)
                .build();
        GetRoleOutput getRoleOutput = client.getRole(getRoleInput);

        System.out.println("GetRole : " + getRoleOutput.getRole().getName());


        // AssignUsers
        String user = getUsernameWithoutDomain();

        AssignUsersInput assignUsersInput = AssignUsersInput.builder()
                .roles(of(ROLE_NAME))
                .users(of(user))
                .build();
        client.assignUsers(assignUsersInput);


        // GetAssignedUsers
        GetAssignedUsersInput getAssignedUsersInput = GetAssignedUsersInput.builder()
                .roles(of(ROLE_NAME))
                .build();
        GetAssignedUsersOutput getAssignedUsersOutput = client.getAssignedUsers(getAssignedUsersInput);

        System.out.println("GetAssignedUsers: " + String.join(", ", getAssignedUsersOutput.getUsers()));


        // UnassignUsers
        UnassignUsersInput unassignUsersInput = UnassignUsersInput.builder()
                .roles(of(ROLE_NAME))
                .users(of(user))
                .build();
        client.unassignUsers(unassignUsersInput);


        // ListRoles
        Pagination pagination = Pagination.builder()
                .pageNumber(0)
                .pageSize(1)
                .build();

        ListRolesInput listRolesInput = ListRolesInput.builder()
                .searchValue(ROLE_NAME)
                .pagination(pagination)
                .build();
        ListRolesOutput listRolesOutput = client.listRoles(listRolesInput);

        System.out.println("ListRoles: " + listRolesOutput.getRoles()
                .stream().map(Role::getName)
                .collect(Collectors.joining(", ")));


        // DeleteRole
        DeleteRoleInput deleteRoleInput = DeleteRoleInput.builder()
                .name(ROLE_NAME)
                .build();
        client.deleteRole(deleteRoleInput);

        // GetRoleFilters
        GetRoleFiltersInput input = GetRoleFiltersInput.builder()
            .roles(Arrays.asList("papel"))
            .domainName("domainName")
            .serviceName("serviceName")
            .build();

        GetRoleFiltersOutput getRoleFiltersOutput = client.getRoleFilters(input);
    }

}
