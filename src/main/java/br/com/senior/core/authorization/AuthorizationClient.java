package br.com.senior.core.authorization;

import br.com.senior.core.authorization.pojos.AssignUsersInput;
import br.com.senior.core.authorization.pojos.AssignUsersOutput;
import br.com.senior.core.authorization.pojos.CheckAccessInput;
import br.com.senior.core.authorization.pojos.CheckAccessOutput;
import br.com.senior.core.authorization.pojos.CreateRoleInput;
import br.com.senior.core.authorization.pojos.CreateRoleOutput;
import br.com.senior.core.authorization.pojos.DeleteResourcesInput;
import br.com.senior.core.authorization.pojos.DeleteResourcesOutput;
import br.com.senior.core.authorization.pojos.DeleteRoleInput;
import br.com.senior.core.authorization.pojos.DeleteRoleOutput;
import br.com.senior.core.authorization.pojos.GetAssignedUsersInput;
import br.com.senior.core.authorization.pojos.GetAssignedUsersOutput;
import br.com.senior.core.authorization.pojos.GetResourceInput;
import br.com.senior.core.authorization.pojos.GetResourceOutput;
import br.com.senior.core.authorization.pojos.GetRoleInput;
import br.com.senior.core.authorization.pojos.GetRoleOutput;
import br.com.senior.core.authorization.pojos.SaveResourcesInput;
import br.com.senior.core.authorization.pojos.SaveResourcesOutput;
import br.com.senior.core.authorization.pojos.UnassignUsersInput;
import br.com.senior.core.authorization.pojos.UnassignUsersOutput;
import br.com.senior.core.utils.BaseClient;
import br.com.senior.core.utils.EndpointPath;
import br.com.senior.core.utils.Environment;
import br.com.senior.core.utils.ServiceException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * Cliente do serviço de  <a href="https://dev.senior.com.br/apis/platform_platform-authorization">Autorização</a>
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorizationClient extends BaseClient {

    String token;

    /**
     * Construtor
     *
     * @param token
     */
    public AuthorizationClient(String token) {
        super("platform", "authorization");
        this.token = token;
    }

    /**
     * Construtor
     *
     * @param env
     * @param token
     */
    public AuthorizationClient(Environment env, String token) {
        super("platform", "authorization", env);
        this.token = token;
    }

    /**
     * Para cada recurso informado, retorna se o usuário corrente possui permissão.
     * Se o usuário possuir permissão e marcar para incluir os filtros, irá retornar os filtros de serviço e recurso associados.
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public CheckAccessOutput checkAccess(CheckAccessInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.CHECK_ACCESS), payload, this.token, CheckAccessOutput.class);
    }

    /**
     * Cria ou atualiza recursos juntamente com suas ações.
     * Recursos e ações que já existirem são atualizados, ações que já existirem no recurso são mantidas.
     * Campos omitidos ou vazios serão ignorados.
     * O campo nome do recurso é obrigatório na criação de um novo recurso.
     * Só serão permitidas alterações em recursos customizados.
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public SaveResourcesOutput saveResources(SaveResourcesInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.SAVE_RESOURCES), payload, this.token, SaveResourcesOutput.class);
    }

    /**
     * Deleta recursos juntamente com suas ações.
     * Somente é possível remover recursos customizados
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public DeleteResourcesOutput deleteResources(DeleteResourcesInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.DELETE_RESOURCES), payload, this.token, DeleteResourcesOutput.class);
    }

    /**
     * Retorna os dados de um recurso
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public GetResourceOutput getResource(GetResourceInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.GET_RESOURCES), payload, this.token, GetResourceOutput.class);
    }

    /**
     * Cria um novo papel
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public CreateRoleOutput createRole(CreateRoleInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.CREATE_ROLE), payload, this.token, CreateRoleOutput.class);
    }

    /**
     * Vincula um ou mais usuários à um ou mais papéis, lançando o evento rolePermissionsChanged com os usuários incluídos
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public AssignUsersOutput assignUsers(AssignUsersInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.ASSIGN_USER), payload, this.token, AssignUsersOutput.class);
    }

    /**
     * Remove um ou mais usuários de um ou mais papéis, lançando o evento rolePermissionsChanged com os usuários removidos
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public UnassignUsersOutput unassignUsers(UnassignUsersInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.UNASSIGN_USER), payload, this.token, UnassignUsersOutput.class);
    }

    /**
     * Retorna uma lista de usuários que estão vinculados em ao menos um dos papéis informados
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public GetAssignedUsersOutput getAssignedUsers(GetAssignedUsersInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.GET_ASSIGN_USERS), payload, this.token, GetAssignedUsersOutput.class);
    }

    /**
     * Retorna os dados de um papel
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public GetRoleOutput getRole(GetRoleInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.GET_ROLE), payload, this.token, GetRoleOutput.class);
    }

    /**
     * Deleta um papel
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public DeleteRoleOutput deleteRole(DeleteRoleInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.DELETE_ROLE), payload, this.token, DeleteRoleOutput.class);
    }
}
