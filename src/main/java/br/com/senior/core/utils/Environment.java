package br.com.senior.core.utils;

import lombok.Getter;

public enum Environment {
    PROD("https://platform.senior.com.br/t/senior.com.br/bridge/1.0"),
    HOMOLOG("https://platform-homologx.senior.com.br/t/senior.com.br/bridge/1.0");
    @Getter
    private final String url;

    Environment(String url) {
        this.url = url;
    }
}
