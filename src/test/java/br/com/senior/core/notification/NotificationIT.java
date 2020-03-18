package br.com.senior.core.notification;

import br.com.senior.core.BaseIT;
import br.com.senior.core.authentication.AuthenticationClient;
import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.notification.pojos.NotifyUserInput;
import br.com.senior.core.notification.pojos.NotifyUserOutput;
import br.com.senior.core.notification.pojos.UserNotificationKind;
import br.com.senior.core.notification.pojos.UserNotificationPriority;
import br.com.senior.core.utils.ServiceException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Exemplos de código do {@link br.com.senior.core.notification.NotificationClient NotificationClient}
 */
public class NotificationIT extends BaseIT {

    private static String token;
    private static NotificationClient client;

    @BeforeClass
    public static void beforeClass() throws ServiceException {
        token = new AuthenticationClient().login(new LoginInput(System.getenv("username"), System.getenv("password_valid"))).getJsonToken().getAccess_token();
    }

    @Test
    public void testNotifyUser() throws ServiceException {
        NotifyUserInput input = NotifyUserInput.builder()
                .destinationUser("user@tenant.com")
                .notificationOrigin("USUÁRIO")
                .notificationClass("br.com.senior.platform.user.model.Usuario")
                .notificationKind(UserNotificationKind.Operational)
                .notificationPriority(UserNotificationPriority.Alert)
                .notificationContent("Usuário registrado com sucesso")
                .notificationSubject("Registro de Usuário")
                .sourceDomain("PLATFORM")
                .sourceService("USER")
                .build();

        NotifyUserOutput output = client.notifyUser(input);
        Assert.assertNotNull(output);
        Assert.assertTrue(output.ok);
    }

}
