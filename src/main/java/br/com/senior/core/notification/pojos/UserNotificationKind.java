package br.com.senior.core.notification.pojos;

import com.google.gson.annotations.SerializedName;

/**
 * Tipos de notificação
 */
public enum UserNotificationKind {

    @SerializedName("Operational")
    OPERATIONAL,
    @SerializedName("Management")
    MANAGEMENT,
    @SerializedName("News")
    NEWS

}
