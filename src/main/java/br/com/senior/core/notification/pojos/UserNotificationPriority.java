package br.com.senior.core.notification.pojos;

import com.google.gson.annotations.SerializedName;

/**
 * Prioridade de notificação
 */
public enum UserNotificationPriority {

    @SerializedName("Error")
    ERROR,
    @SerializedName("Alert")
    ALERT,
    @SerializedName("None")
    NONE

}
