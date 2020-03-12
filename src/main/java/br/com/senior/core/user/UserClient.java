package br.com.senior.core.user;

import br.com.senior.core.user.pojos.GetUserInput;
import br.com.senior.core.user.pojos.GetUserOutput;
import br.com.senior.core.utils.BaseClient;
import br.com.senior.core.utils.EndpointPath;
import br.com.senior.core.utils.Environment;
import br.com.senior.core.utils.ServiceException;

public class UserClient extends BaseClient {

    public UserClient() {
        super("platform", "user");
    }

    public UserClient(Environment env) {
        super("platform", "user", env);
    }

    /**
     * Retorna as informações básicas do usuário passado como parâmetro. Se o usuário não for informado, retorna os dados do usuário corrente (que efetuou o login)
     */
    public GetUserOutput getUser(GetUserInput payload, String token) throws ServiceException {
        return execute(getQueriesUrl(EndpointPath.GET_USER), payload, token, GetUserOutput.class);
    }

}
