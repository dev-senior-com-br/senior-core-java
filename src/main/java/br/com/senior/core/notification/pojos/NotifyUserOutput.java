package br.com.senior.core.notification.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.notification.NotificationClient#notifyUser(NotifyUserInput)}  notifyUser}
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotifyUserOutput {

    /**
     * Boolean indicating operation success
     */
    @NonNull
    public Boolean ok;

}
