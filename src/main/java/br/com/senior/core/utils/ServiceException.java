package br.com.senior.core.utils;

import java.io.IOException;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServiceException extends Exception {

    int errorCode;

    public ServiceException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(String message, IOException e) {
        super(message, e);
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                (errorCode != 0 ? ("errorCode=" + errorCode) : "") +
                ", message='" + getMessage() + '\'' +
                '}';
    }
}
