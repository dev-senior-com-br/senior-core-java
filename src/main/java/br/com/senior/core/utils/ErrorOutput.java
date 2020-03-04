package br.com.senior.core.utils;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorOutput {

    String message;
    String reason;
    String domain;
    String service;

    public ErrorOutput(String message, String reason, String domain, String service) {
        this.message = message;
        this.reason = reason;
        this.domain = domain;
        this.service = service;
    }

    @Override
    public String toString() {
        return "ErrorOutput{" +
                "message='" + message + '\'' +
                ", reason='" + reason + '\'' +
                ", domain='" + domain + '\'' +
                ", service='" + service + '\'' +
                '}';
    }
}