package br.com.senior.examples.authorization;

import br.com.senior.core.authorization.AuthorizationClient;
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
import br.com.senior.core.authorization.pojos.GetResourcesInput;
import br.com.senior.core.authorization.pojos.GetResourcesOutput;
import br.com.senior.core.authorization.pojos.GetRoleInput;
import br.com.senior.core.authorization.pojos.GetRoleOutput;
import br.com.senior.core.authorization.pojos.ListRolesInput;
import br.com.senior.core.authorization.pojos.ListRolesOutput;
import br.com.senior.core.authorization.pojos.PermissionToCheck;
import br.com.senior.core.authorization.pojos.Resource;
import br.com.senior.core.authorization.pojos.SaveResourcesInput;
import br.com.senior.core.authorization.pojos.SaveResourcesOutput;
import br.com.senior.core.authorization.pojos.UnassignUsersInput;
import br.com.senior.core.base.ServiceException;
import br.com.senior.core.user.pojos.Pagination;
import br.com.senior.examples.BaseExample;

import static java.util.List.of;
import static java.util.stream.Collectors.toList;

/**
 * Exemplos de código do Serviço Authorization
 */
public class AuthorizationExample extends BaseExample {

    private static final String RESOURCE_URI = "res://tenant/dominio/servico/recurso";
    private static final String ROLE_NAME = "PapelParaTestes";

    private static AuthorizationClient client;

    /**
     * Utilizando o {@link br.com.senior.core.authorization.AuthorizationClient AuthorizationClient}
     *
     * @param args - Argumentos de linha de comando
     * @throws ServiceException - Erro tratado de serviço
     */
    public static void main(String[] args) throws ServiceException {

        // Login
        String accessToken = getAccessToken();

        client = new AuthorizationClient(ENVIRONMENT, accessToken);


        // SaveResources
        Resource resource = new Resource("Recurso de Exemplo", RESOURCE_URI,
                of(new Action("Visualizar"), new Action("Editar")));

        SaveResourcesInput saveResourcesInput = new SaveResourcesInput(of(resource));
        SaveResourcesOutput saveResourcesOutput = client.saveResources(saveResourcesInput);

        System.out.println("SaveResources: " + String.join(", ", saveResourcesOutput.getResources().stream().map(Resource::getUri).collect(toList())));


        // GetResources
        GetResourcesInput getResourcesInput = new GetResourcesInput(of(RESOURCE_URI));
        GetResourcesOutput getResourcesOutput = client.getResources(getResourcesInput);

        System.out.println("GetResources: " + getResourcesOutput.getResources().get(0).getUri());


        // DeleteResources
        DeleteResourcesInput deleteResourcesInput = new DeleteResourcesInput(of(RESOURCE_URI));
        client.deleteResources(deleteResourcesInput);


        // CheckAccess
        PermissionToCheck permissionToCheck = new PermissionToCheck(
                "res://senior.com.br/security/usermanager/usuario",
                "Visualizar");
        CheckAccessInput checkAccessInput = new CheckAccessInput(of(permissionToCheck), false, false);
        CheckAccessOutput checkAccessOutput = client.checkAccess(checkAccessInput);

        System.out.println("CheckAccess: " + checkAccessOutput.getAuthorized());


        // CreateRole
        CreateRoleInput createRoleInput = new CreateRoleInput(ROLE_NAME, "papel para testes de integração");
        CreateRoleOutput createRoleOutput = client.createRole(createRoleInput);

        System.out.println("CreateRole : " + createRoleOutput.getName());


        // GetRole
        GetRoleInput getRoleInput = new GetRoleInput(ROLE_NAME);
        GetRoleOutput getRoleOutput = client.getRole(getRoleInput);

        System.out.println("GetRole : " + getRoleOutput.getRole().getName());


        // AssignUsers
        String user = getUsernameWithoutDomain();
        AssignUsersInput assignUsersInput = new AssignUsersInput(of(ROLE_NAME), of(user));
        client.assignUsers(assignUsersInput);


        // GetAssignedUsers
        GetAssignedUsersInput getAssignedUsersInput = new GetAssignedUsersInput(of(ROLE_NAME));
        GetAssignedUsersOutput getAssignedUsersOutput = client.getAssignedUsers(getAssignedUsersInput);

        System.out.println("GetAssignedUsers: " + getAssignedUsersOutput.users.get(0));


        // UnassignUsers
        UnassignUsersInput unassignUsersInput = new UnassignUsersInput(of(ROLE_NAME), of(user));
        client.unassignUsers(unassignUsersInput);


        // ListRoles
        Pagination pagination = new Pagination();
        pagination.pageNumber = 0;
        pagination.pageSize = 1;

        ListRolesInput listRolesInput = new ListRolesInput(ROLE_NAME, pagination);
        ListRolesOutput listRolesOutput = client.listRoles(listRolesInput);

        System.out.println("ListRoles: " + listRolesOutput.getRoles().get(0).getName());


        // DeleteRole
        DeleteRoleInput deleteRoleInput = new DeleteRoleInput(ROLE_NAME);
        DeleteRoleOutput deleteRoleOutput = client.deleteRole(deleteRoleInput);
    }

}