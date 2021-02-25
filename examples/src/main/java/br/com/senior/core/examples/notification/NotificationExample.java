package br.com.senior.core.examples.notification;

import br.com.senior.core.base.ServiceException;
import br.com.senior.core.examples.BaseExample;
import br.com.senior.core.notification.NotificationClient;
import br.com.senior.core.notification.pojos.NotifyUserInput;
import br.com.senior.core.notification.pojos.NotifyUserOutput;
import br.com.senior.core.notification.pojos.UserNotificationKind;
import br.com.senior.core.notification.pojos.UserNotificationPriority;

import static java.util.List.of;

/**
 * Exemplos de código do Serviço Notification
 */
public class NotificationExample extends BaseExample {

    private static final String RESOURCE_URI = "res://tenant/dominio/servico/recurso";
    private static final String ROLE_NAME = "PapelParaTestes";

    private static NotificationClient client;

    /**
     * Utilizando o {@link br.com.senior.core.notification.NotificationClient NotificationClient}
     *
     * @param args - Argumentos de linha de comando
     * @throws ServiceException - Erro tratado de serviço
     */
    public static void main(String[] args) throws ServiceException {

        // Login
        String accessToken = getAccessToken();

        client = new NotificationClient(accessToken);


        // NotifyUser
        NotifyUserInput notifyUserInput = NotifyUserInput.builder()
                //.destinationUser(System.getenv("SENIOR_USERNAME"))
                .notificationOrigin("Teste")
                .notificationKind(UserNotificationKind.OPERATIONAL)
                .notificationPriority(UserNotificationPriority.ALERT)
                .notificationContent("Conteúdo")
                .notificationSubject("Teste de Notificação")
                .notificationClass("Classe da notificação")
                .sourceDomain("platform")
                .sourceService("tenant")
                .destinationUsers(of(System.getenv("SENIOR_USERNAME")))
                .build();

        NotifyUserOutput notifyUserOutput = client.notifyUser(notifyUserInput);
        System.out.println("NotifyUser: " + notifyUserOutput.ok);
    }

}
