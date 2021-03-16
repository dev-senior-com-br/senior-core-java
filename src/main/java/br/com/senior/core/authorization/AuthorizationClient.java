package br.com.senior.core.authorization;

import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.authentication.pojos.LoginMFAInput;
import br.com.senior.core.authentication.pojos.LoginWithKeyInput;
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
import br.com.senior.core.authorization.pojos.GetResourcesInput;
import br.com.senior.core.authorization.pojos.GetResourcesOutput;
import br.com.senior.core.authorization.pojos.GetRoleFiltersInput;
import br.com.senior.core.authorization.pojos.GetRoleFiltersOutput;
import br.com.senior.core.authorization.pojos.GetRoleInput;
import br.com.senior.core.authorization.pojos.GetRoleOutput;
import br.com.senior.core.authorization.pojos.ListRolesInput;
import br.com.senior.core.authorization.pojos.ListRolesOutput;
import br.com.senior.core.authorization.pojos.SaveResourcesInput;
import br.com.senior.core.authorization.pojos.SaveResourcesOutput;
import br.com.senior.core.authorization.pojos.UnassignUsersInput;
import br.com.senior.core.authorization.pojos.UnassignUsersOutput;
import br.com.senior.core.base.BaseClient;
import br.com.senior.core.utils.EndpointPath;
import br.com.senior.core.base.Environment;
import br.com.senior.core.base.ServiceException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * Cliente do serviço de  <a href="https://dev.senior.com.br/api_publica/platform_authorization">Autorização</a>
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorizationClient extends BaseClient {

    final String token;

    /**
     * Construtor
     *
     * @param token - Access-token gerado no {@link br.com.senior.core.authentication.AuthenticationClient#login(LoginInput) login},
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginMFA(LoginMFAInput) loginMFA} e
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginWithKey(LoginWithKeyInput) loginWithKey}
     */
    public AuthorizationClient(String token) {
        super("platform", "authorization");
        this.token = token;
    }

    /**
     * Construtor
     *
     * @param env   - Variáveis de ambiente
     * @param token - Access-token gerado no {@link br.com.senior.core.authentication.AuthenticationClient#login(LoginInput) login},
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginMFA(LoginMFAInput) loginMFA} e
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginWithKey(LoginWithKeyInput) loginWithKey}
     */
    public AuthorizationClient(Environment env, String token) {
        super("platform", "authorization", env);
        this.token = token;
    }

    /**
     * Para cada recurso informado, retorna se o usuário corrente possui permissão.
     * Se o usuário possuir permissão e marcar para incluir os filtros, irá retornar os filtros de serviço e recurso associados.
     *
     * @param payload - Payload de entrada com a permissões a serem verificadas
     * @return - Payload de saída com os permissões que o usuário possui
     * @throws ServiceException - Erro tratado de serviço
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
     * @param payload - Payload de entrada com os recursos a serem gravados
     * @return - Payload de saída com os recursos gravados
     * @throws ServiceException - Erro tratado de serviço
     */
    public SaveResourcesOutput saveResources(SaveResourcesInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.SAVE_RESOURCES), payload, this.token, SaveResourcesOutput.class);
    }

    /**
     * Deleta recursos juntamente com suas ações.
     * Somente é possível remover recursos customizados
     *
     * @param payload - Payload de entrada com os recursos a serem removidos
     * @return - Payload de saída sem informações
     * @throws ServiceException - Erro tratado de serviço
     */
    public DeleteResourcesOutput deleteResources(DeleteResourcesInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.DELETE_RESOURCES), payload, this.token, DeleteResourcesOutput.class);
    }

    /**
     * Retorna os dados de um recurso
     *
     * @param payload - Payload de entrada com as URIs dos recursos a serem obtidos
     * @return - Payload de saída com os recursos obtidos
     * @throws ServiceException - Erro tratado de serviço
     */
    public GetResourcesOutput getResources(GetResourcesInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.GET_RESOURCES), payload, this.token, GetResourcesOutput.class);
    }

    /**
     * Cria um novo papel
     *
     * @param payload - Payload de entrada com os dados dos papéis a serem gravados
     * @return - Payload de saída com o nome dos papéis gravados
     * @throws ServiceException - Erro tratado de serviço
     */
    public CreateRoleOutput createRole(CreateRoleInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.CREATE_ROLE), payload, this.token, CreateRoleOutput.class);
    }

    /**
     * Vincula um ou mais usuários à um ou mais papéis, lançando o evento rolePermissionsChanged com os usuários incluídos
     *
     * @param payload - Payload de entrada com os usuários e papéis a serem associados
     * @return - Payload de saída vazio
     * @throws ServiceException - Erro tratado de serviço
     */
    public AssignUsersOutput assignUsers(AssignUsersInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.ASSIGN_USER), payload, this.token, AssignUsersOutput.class);
    }

    /**
     * Remove um ou mais usuários de um ou mais papéis, lançando o evento rolePermissionsChanged com os usuários removidos
     *
     * @param payload - Payload de entrada com os usuários e papéis a serem desassociados
     * @return - Payload de saída vazio
     * @throws ServiceException - Erro tratado de serviço
     */
    public UnassignUsersOutput unassignUsers(UnassignUsersInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.UNASSIGN_USER), payload, this.token, UnassignUsersOutput.class);
    }

    /**
     * Retorna uma lista de usuários que estão vinculados em ao menos um dos papéis informados
     *
     * @param payload - Payload de entrada com as roles que serão consultadas para obter os usuários associados
     * @return - Payload de saída com a lista de usuários
     * @throws ServiceException - Erro tratado de serviço
     */
    public GetAssignedUsersOutput getAssignedUsers(GetAssignedUsersInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.GET_ASSIGN_USERS), payload, this.token, GetAssignedUsersOutput.class);
    }

    /**
     * Retorna os dados de um papel
     *
     * @param payload - Payload de entrada com o nome do papel a ser consultado
     * @return - Payload de saída com os dados do papel
     * @throws ServiceException - Erro tratado de serviço
     */
    public GetRoleOutput getRole(GetRoleInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.GET_ROLE), payload, this.token, GetRoleOutput.class);
    }

    /**
     * Deleta um papel
     *
     * @param payload - Payload de entrada com o nome do papel a ser removida
     * @return - Payload de saída vazio
     * @throws ServiceException - Erro tratado de serviço
     */
    public DeleteRoleOutput deleteRole(DeleteRoleInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Authorization.DELETE_ROLE), payload, this.token, DeleteRoleOutput.class);
    }

    /**
     * Retorna os dados de um papel
     *
     * @param payload - Payload de entrada com o nome do papel a ser consultado
     * @return - Payload de saída com os dados do papel
     * @throws ServiceException - Erro tratado de serviço
     */
    public ListRolesOutput listRoles(ListRolesInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.Authorization.LIST_ROLES), payload, this.token, ListRolesOutput.class);
    }

    /**
     * Retorna a união dos filtros de um papel
     *
     * @param payload - Payload de entrada com os nomes dos papéis a serem consultados
     * @return - Payload de saída com a união dos filtros
     * @throws ServiceException - Erro tratado de serviço
     */
    public GetRoleFiltersOutput getRoleFilters(GetRoleFiltersInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.Authorization.GET_ROLE_FILTERS), payload, this.token, GetRoleFiltersOutput.class);
    }
}
