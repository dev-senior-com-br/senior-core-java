package br.com.senior.core.notification;

import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.authentication.pojos.LoginMFAInput;
import br.com.senior.core.authentication.pojos.LoginWithKeyInput;
import br.com.senior.core.notification.pojos.NotifyUserInput;
import br.com.senior.core.notification.pojos.NotifyUserOutput;
import br.com.senior.core.base.BaseClient;
import br.com.senior.core.utils.EndpointPath;
import br.com.senior.core.base.Environment;
import br.com.senior.core.base.ServiceException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * Cliente o serviço de <a href="https://dev.senior.com.br/apis/platform_notifications">Notificação</a>
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotificationClient extends BaseClient {

    String token;

    /**
     * Construtor
     *
     * @param token - Access-token gerado no {@link br.com.senior.core.authentication.AuthenticationClient#login(LoginInput) login},
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginMFA(LoginMFAInput) loginMFA} e
     *              {@link br.com.senior.core.authentication.AuthenticationClient#loginWithKey(LoginWithKeyInput) loginWithKey}
     */
    public NotificationClient(String token) {
        super("platform", "notifications");
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
    public NotificationClient(Environment env, String token) {
        super("platform", "notifications", env);
        this.token = token;
    }

    /**
     * Envia uma notificação para um usuário
     *
     * @param payload - Payload de entrada com os dados da notificação
     * @return - Payload de saída informado status da notificação
     * @throws ServiceException - Erro tratado de serviço
     */
    public NotifyUserOutput notifyUser(NotifyUserInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Notification.NOTIFY_USER), payload, this.token, NotifyUserOutput.class);
    }
}
