package br.com.senior.core.notification.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de entrada do {@link br.com.senior.core.notification.NotificationClient#notifyUser(NotifyUserInput) notifyUser}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotifyUserInput {

    /**
     * Class of notification. Identifies the context of the notification/group of notifications.
     * ATTENTION: THIS FIELD WILL BECOME REQUIRED AS OF AUGUST 2019.
     */
    String notificationClass;
    /**
     * Origin of notification. Free text.
     */
    String notificationOrigin;
    /**
     * Notification kind
     */
    UserNotificationKind notificationKind;
    /**
     * Notification priority
     */
    UserNotificationPriority notificationPriority;
    /**
     * Notification subject
     */
    String notificationSubject;
    /**
     * Notification content
     */
    String notificationContent;
    /**
     * Domain that generates the notification
     */
    String sourceDomain;
    /**
     * Service that generates the notification
     */
    String sourceService;
    /**
     * Names of the destination users
     */
    List<String> destinationUsers;
    /**
     * Name of the destination user
     */
    String destinationUser;
    /**
     * Notification link.
     */
    String link;

}
