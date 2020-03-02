package br.com.senior.core.user;

import com.google.gson.GsonBuilder;

import br.com.senior.core.BaseClient;
import br.com.senior.core.Environment;
import br.com.senior.core.ServiceException;
import br.com.senior.core.user.pojos.GetUserInput;
import br.com.senior.core.user.pojos.GetUserOutput;

public class UserClient extends BaseClient {

    public UserClient() {
        super("platform", "user");
    }

    public UserClient(Environment env) {
        super("platform", "user", env);
    }

    /**
     * Recupera dados do usuário logado.
     */
    public GetUserOutput getUser(GetUserInput payload, String token) throws ServiceException {
        GsonBuilder gson = new GsonBuilder();
        return gson.create().fromJson(execute(getQueriesUrl() + "getUser", payload, token), GetUserOutput.class);
    }

}
