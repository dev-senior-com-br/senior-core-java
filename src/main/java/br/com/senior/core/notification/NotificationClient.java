package br.com.senior.core.notification;

import br.com.senior.core.notification.pojos.NotifyUserInput;
import br.com.senior.core.notification.pojos.NotifyUserOutput;
import br.com.senior.core.utils.BaseClient;
import br.com.senior.core.utils.EndpointPath;
import br.com.senior.core.utils.Environment;
import br.com.senior.core.utils.ServiceException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

/**
 * Cliente o serviço de <a href="https://dev.senior.com.br/apis/platform_notifications">Notificação</a>
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotificationClient extends BaseClient {

    String token;

    public NotificationClient(String token) {
        super("platform", "notification");
        this.token = token;
    }

    public NotificationClient(Environment env, String token) {
        super("platform", "notification", env);
        this.token = token;
    }

    /**
     * Envia uma notificação para um usuário
     */
    public NotifyUserOutput notifyUser(NotifyUserInput payload) throws ServiceException {
        return execute(getActionsUrl(EndpointPath.Notification.NOTIFY_USER), payload, this.token, NotifyUserOutput.class);
    }
}
