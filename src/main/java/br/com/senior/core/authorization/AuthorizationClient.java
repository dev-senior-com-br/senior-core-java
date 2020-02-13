package br.com.senior.core.authorization;

import br.com.senior.core.BaseClient;
import br.com.senior.core.Environment;
import br.com.senior.core.ServiceException;
import br.com.senior.core.authorization.pojos.*;
import com.google.gson.Gson;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorizationClient extends BaseClient {

    String token;

    public AuthorizationClient(String token) {
        super("platform", "authorization");
        this.token = token;
    }

    public AuthorizationClient(Environment env, String token) {
        super("platform", "authorization", env);
        this.token = token;
    }

    /**
     * Para cada recurso informado, retorna se o usuário corrente possui permissão.
     * Se o usuário possuir permissão e marcar para incluir os filtros, irá retornar os filtros de serviço e recurso associados.
     */
    public CheckAccessOutput checkAccess(CheckAccessInput payload) throws ServiceException {
        return new Gson().fromJson(execute(getActionsUrl() + "checkAccess", payload, this.token), CheckAccessOutput.class);
    }

    /**
     * Cria ou atualiza recursos juntamente com suas ações.
     * Recursos e ações que já existirem são atualizados, ações que já existirem no recurso são mantidas.
     * Campos omitidos ou vazios serão ignorados.
     * O campo nome do recurso é obrigatório na criação de um novo recurso.
     * Só serão permitidas alterações em recursos customizados.
     */
    public SaveResourcesOutput saveResources(SaveResourcesInput payload) throws ServiceException {
        return new Gson().fromJson(execute(getActionsUrl() + "saveResources", payload, this.token), SaveResourcesOutput.class);
    }

    /**
     * Deleta recursos juntamente com suas ações.
     * Somente é possível remover recursos customizados
     */
    public DeleteResourcesOutput deleteResources(DeleteResourcesInput payload) throws ServiceException {
        return new Gson().fromJson(execute(getActionsUrl() + "deleteResources", payload, this.token), DeleteResourcesOutput.class);
    }

    /**
     * Retorna os dados de um recurso
     */
    public GetResourcesOutput getResource(GetResourcesInput payload) throws ServiceException {
        return new Gson().fromJson(execute(getActionsUrl() + "getResources", payload, this.token), GetResourcesOutput.class);
    }

    /**
     * Cria um novo papel
     */
    public CreateRoleOutput createRole(CreateRoleInput payload) throws ServiceException {
        return new Gson().fromJson(execute(getActionsUrl() + "createRole", payload, this.token), CreateRoleOutput.class);
    }

    /**
     * Vincula um ou mais usuários à um ou mais papéis, lançando o evento rolePermissionsChanged com os usuários incluídos
     */
    public AssignUsersOutput assignUsers(AssignUsersInput payload) throws ServiceException {
        return new Gson().fromJson(execute(getActionsUrl() + "assignUsers", payload, this.token), AssignUsersOutput.class);
    }

    /**
     * Remove um ou mais usuários de um ou mais papéis, lançando o evento rolePermissionsChanged com os usuários removidos
     */
    public UnassignUsersOutput unassignUsers(UnassignUsersInput payload) throws ServiceException {
        return new Gson().fromJson(execute(getActionsUrl() + "unassignUsers", payload, this.token), UnassignUsersOutput.class);
    }

    /**
     * Retorna uma lista de usuários que estão vinculados em ao menos um dos papéis informados
     */
    public GetAssignedUsersOutput getAssignedUsers(GetAssignedUsersInput payload) throws ServiceException {
        return new Gson().fromJson(execute(getActionsUrl() + "getAssignedUsers", payload, this.token), GetAssignedUsersOutput.class);
    }

    /**
     * Retorna os dados de um papel
     */
    public GetRoleOutput getRole(GetRoleInput payload) throws ServiceException {
        return new Gson().fromJson(execute(getActionsUrl() + "getRole", payload, this.token), GetRoleOutput.class);
    }

    /**
     * Deleta um papel
     */
    public DeleteRoleOutput deleteRole(DeleteRoleInput payload) throws ServiceException {
        return new Gson().fromJson(execute(getActionsUrl() + "deleteRole", payload, this.token), DeleteRoleOutput.class);
    }
}
