package br.com.senior.core.base;

import lombok.Getter;

/**
 * Tipos de Ambiente
 */
public enum Environment {

    PROD("https://api.senior.com.br"),
    HOMOLOG("https://platform-homologx.senior.com.br/t/senior.com.br/bridge/1.0");

    @Getter
    private final String url;

    /**
     * Construtor
     *
     * @param url - URL
     */
    Environment(String url) {
        this.url = url;
    }
}
