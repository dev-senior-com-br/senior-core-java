package br.com.senior.core.tenant.utils;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Response<T> {
    @NonNull
    T body;
}
