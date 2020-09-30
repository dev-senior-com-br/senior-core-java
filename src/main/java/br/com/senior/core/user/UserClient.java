package br.com.senior.core.user;

import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.authentication.pojos.LoginMFAInput;
import br.com.senior.core.authentication.pojos.LoginWithKeyInput;
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
import br.com.senior.core.base.BaseClient;
import br.com.senior.core.utils.EndpointPath;
import br.com.senior.core.base.Environment;
import br.com.senior.core.base.ServiceException;

/**
 * Cliente o serviço de <a href="https://dev.senior.com.br/apis/platform_user/">Usuários</a>
 */
public class UserClient extends BaseClient {

    private String token;

    /**
     * Construtor
     *
     * @param token - Access-token gerado no {@link br.com.senior.core.authentication.AuthenticationClient#login(LoginInput) login},
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginMFA(LoginMFAInput) loginMFA} e
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginWithKey(LoginWithKeyInput) loginWithKey}
     */
    public UserClient(String token) {
        super("platform", "user");
        this.token = token;
    }

    /**
     * Construtor
     *
     * @param token - Access-token gerado no {@link br.com.senior.core.authentication.AuthenticationClient#login(LoginInput) login},
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginMFA(LoginMFAInput) loginMFA} e
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginWithKey(LoginWithKeyInput) loginWithKey}
     * @param env   - Variáveis de ambiente
     */
    public UserClient(String token, Environment env) {
        super("platform", "user", env);
        this.token = token;
    }

    /**
     * Retorna as informações básicas do usuário passado como parâmetro. Se o usuário não for informado, retorna os dados do usuário corrente (que efetuou o login)
     *
     * @param payload - Payload de entrada com o login do usuário
     * @return - Payload de saída com os dados do usuário
     * @throws ServiceException - Erro tratado de serviço
     */
    public GetUserOutput getUser(GetUserInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.GET_USER), payload, this.token, GetUserOutput.class);
    }

    /**
     * Insere um novo usuário na base
     *
     * @param payload - Payload de entrada com os dados do usuário
     * @return - Payload de saída com o login do usuário
     * @throws ServiceException - Erro tratado de serviço
     */
    public CreateUserOutput createUser(CreateUserInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.CREATE_USER), payload, this.token, CreateUserOutput.class);
    }

    /**
     * Altera as informações de um usuário
     *
     * @param payload - Payload de entrada com os dados do usuário
     * @return - Payload de saída com o login do usuário
     * @throws ServiceException - Erro tratado de serviço
     */
    public UpdateUserOutput updateUser(UpdateUserInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.UPDATE_USER), payload, this.token, UpdateUserOutput.class);
    }

    /**
     * Retorna as informações de um grupo
     *
     * @param payload - Payload de entrada com o identificado do grupo
     * @return - Payload de saída com os dados do grupo
     * @throws ServiceException - Erro tratado de serviço
     */
    public GetGroupOutput getGroup(GetGroupInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.GET_GROUP), payload, this.token, GetGroupOutput.class);
    }

    /**
     * Insere um novo grupo na base.
     *
     * @param payload - Payload de entrada com os dados do grupo
     * @return - Payload de saída com o identificador do grupo
     * @throws ServiceException - Erro tratado de serviço
     */
    public CreateGroupOutput createGroup(CreateGroupInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.CREATE_GROUP), payload, this.token, CreateGroupOutput.class);
    }

    /**
     * Remove um grupo na plataforma.
     *
     * @param id Identificador do grupo para ser removido.
     * @throws ServiceException - Erro tratado de serviço
     */
    public void deleteGroup(DeleteGroupInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.User.DELETE_GROUP), payload, this.token, null);
    }

    /**
     * Remove um usuário na plataforma.
     *
     * @param id Identificador do usuário para ser removido.
     * @throws ServiceException - Erro tratado de serviço
     */
    public void deleteUser(DeleteUserInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.User.DELETE_USER), payload, this.token, null);
    }

    /**
     * Atualiza as informações e os usuários de um grupo
     *
     * @param payload - Payload de entrada com os dados do grupo
     * @return - Payload de saída com o identificador do grupo
     * @throws ServiceException - Erro tratado de serviço
     */
    public UpdateGroupOutput updateGroup(UpdateGroupInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.UPDATE_GROUP), payload, this.token, UpdateGroupOutput.class);
    }

    /**
     * Obtém a lista de todos os grupos
     *
     * @param payload - Payload de entrada com os filtros para pesquisa
     * @return - Payload de saída com a lista de grupos
     * @throws ServiceException - Erro tratado de serviço
     */
    public ListGroupsOutput listGroups(ListGroupsInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.LIST_GROUPS), payload, this.token, ListGroupsOutput.class);
    }

    /**
     * Obtém a lista dos usuários do grupo
     *
     * @param payload - Payload de entrada com o identificado do grupo e outros filtros
     * @return - Payload de saída com a lista de usuários do grupos
     * @throws ServiceException - Erro tratado de serviço
     */
    public ListGroupUsersOutput listGroupUsers(ListGroupUsersInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.LIST_GROUP_USERS), payload, this.token, ListGroupUsersOutput.class);
    }

    /**
     * Adiciona e/ou remove usuários de um grupo
     *
     * @param payload - Payload de entrada com o identificado do grupo e os usuários a serem adicionados e/ou removidos do grupo
     * @return - Payload de saída vazio
     * @throws ServiceException - Erro tratado de serviço
     */
    public UpdateGroupUsersOutput updateGroupUsers(UpdateGroupUsersInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.UPDATE_GROUP_USERS), payload, this.token, UpdateGroupUsersOutput.class);
    }

}
