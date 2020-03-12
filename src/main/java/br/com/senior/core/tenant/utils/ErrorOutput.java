package br.com.senior.core.tenant.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class ErrorOutput {

    String message;
    String reason;
    String domain;
    String service;

}
