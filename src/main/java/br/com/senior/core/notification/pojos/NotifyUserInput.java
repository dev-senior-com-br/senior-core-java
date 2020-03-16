package br.com.senior.core.notification.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.notification.NotificationClient#notifyUser(NotifyUserInput)}  notifyUser}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotifyUserInput {

    /**
     * Class of notification. Identifies the context of the notification/group of notifications.
     * ATTENTION: THIS FIELD WILL BECOME REQUIRED AS OF AUGUST 2019.
     */
    public String notificationClass;
    /**
     * Origin of notification. Free text.
     */
    public String notificationOrigin;
    /**
     * Notification kind
     */
    public UserNotificationKind notificationKind;
    /**
     * Notification priority
     */
    public UserNotificationPriority notificationPriority;
    /**
     * Notification subject
     */
    public String notificationSubject;
    /**
     * Notification content
     */
    public String notificationContent;
    /**
     * Domain that generates the notification
     */
    public String sourceDomain;
    /**
     * Service that generates the notification
     */
    public String sourceService;
    /**
     * Names of the destination users
     */
    public java.util.List<String> destinationUsers;
    /**
     * Name of the destination user
     */
    public String destinationUser;
    /**
     * Notification link.
     */
    public String link;

}
