package br.com.senior.core.notification.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * Payload de saída do {@link br.com.senior.core.notification.NotificationClient#notifyUser(NotifyUserInput) notifyUser}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class NotifyUserOutput {

    /**
     * Boolean indicating operation success
     */
    @NonNull
    Boolean ok;

}
