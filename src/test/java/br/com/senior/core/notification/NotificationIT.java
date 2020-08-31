package br.com.senior.core.notification;

import br.com.senior.core.BaseIT;
import br.com.senior.core.notification.pojos.NotifyUserInput;
import br.com.senior.core.notification.pojos.NotifyUserOutput;
import br.com.senior.core.notification.pojos.UserNotificationKind;
import br.com.senior.core.notification.pojos.UserNotificationPriority;
import br.com.senior.core.base.ServiceException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

/**
 * Exemplos de código do {@link br.com.senior.core.notification.NotificationClient NotificationClient}
 */
public class NotificationIT extends BaseIT {

    private static String token;
    private static NotificationClient client;

    @BeforeClass
    public static void beforeClass() throws ServiceException {
        token = login().getJsonToken().getAccess_token();
        client = new NotificationClient(token);
    }

    @Test
    public void testNotifyUser() throws ServiceException {
        NotifyUserInput input = NotifyUserInput.builder()
                .destinationUser(System.getenv("USERNAME"))
                .notificationOrigin("Teste")
                .notificationKind(UserNotificationKind.OPERATIONAL)
                .notificationPriority(UserNotificationPriority.ALERT)
                .notificationContent("Teste")
                .notificationSubject("Teste")
                .notificationClass("Classe da notificação")
                .sourceDomain("platform")
                .sourceService("tenant")
                .destinationUsers(Arrays.asList("teste@".concat(System.getenv("TENANT_DOMAIN"))))
                .build();

        NotifyUserOutput output = client.notifyUser(input);
        Assert.assertNotNull(output);
        Assert.assertTrue(output.ok);
    }

}
