package br.com.senior.core.user;

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
import br.com.senior.core.utils.BaseClient;
import br.com.senior.core.utils.EndpointPath;
import br.com.senior.core.utils.Environment;
import br.com.senior.core.utils.ServiceException;

/**
 * Cliente o serviço de <a href="https://dev.senior.com.br/apis/platform_user/">Usuários</a>
 */
public class UserClient extends BaseClient {

    private String token;

    public UserClient(String token) {
        super("platform", "user");
        this.token = token;
    }

    public UserClient(String token, Environment env) {
        super("platform", "user", env);
        this.token = token;
    }

    /**
     * Retorna as informações básicas do usuário passado como parâmetro. Se o usuário não for informado, retorna os dados do usuário corrente (que efetuou o login)
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public GetUserOutput getUser(GetUserInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.GET_USER), payload, this.token, GetUserOutput.class);
    }

    /**
     * Insere um novo usuário na base
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public CreateUserOutput createUser(CreateUserInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.CREATE_USER), payload, this.token, CreateUserOutput.class);
    }

    /**
     * Altera as informações de um usuário
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public UpdateUserOutput updateUser(UpdateUserInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.UPDATE_USER), payload, this.token, UpdateUserOutput.class);
    }

    /**
     * Retorna as informações de um grupo
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public GetGroupOutput getGroup(GetGroupInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.GET_GROUP), payload, this.token, GetGroupOutput.class);
    }

    /**
     * Insere um novo grupo na base.
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public CreateGroupOutput createGroup(CreateGroupInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.CREATE_GROUP), payload, this.token, CreateGroupOutput.class);
    }

    /**
     * Remove um grupo na plataforma.
     *
     * @param id Identificador da entidade para ser removida.
     * @throws ServiceException
     */
    public void deleteGroup(String id) throws ServiceException {
        String endPointPath = getDelete(id);
        delete(endPointPath, this.token);
    }

    /**
     * Atualiza as informações e os usuários de um grupo
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public UpdateGroupOutput updateGroup(UpdateGroupInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.UPDATE_GROUP), payload, this.token, UpdateGroupOutput.class);
    }

    /**
     * Obtém a lista de todos os grupos
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public ListGroupsOutput listGroups(ListGroupsInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.LIST_GROUPS), payload, this.token, ListGroupsOutput.class);
    }

    /**
     * Obtém a lista dos usuários do grupo
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public ListGroupUsersOutput listGroupUsers(ListGroupUsersInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.LIST_GROUP_USERS), payload, this.token, ListGroupUsersOutput.class);
    }

    /**
     * Adiciona e/ou remove usuários de um grupo
     *
     * @param payload
     * @return
     * @throws ServiceException
     */
    public UpdateGroupUsersOutput updateGroupUsers(UpdateGroupUsersInput payload) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.User.UPDATE_GROUP_USERS), payload, this.token, UpdateGroupUsersOutput.class);
    }

}
