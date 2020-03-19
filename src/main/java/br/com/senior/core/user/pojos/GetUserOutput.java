package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de saída do {@link br.com.senior.core.user.UserClient#getUser(GetUserInput) getUser}
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetUserOutput {

    /**
     * Identificador do usuário
     */
    String id;

    /**
     * Nome do usuário
     */
    String username;

    /**
     * Nome completo do usuário
     */
    String fullName;

    /**
     * Descrição do usuário
     */
    String description;

    /**
     * Endereço de e-mail do usuário
     */
    String email;

    /**
     * localidade do usuário
     */
    String locale;

    /**
     * Domínio do tenant no login do usuário
     */
    String tenantDomain;

    /**
     * Nome do tenant do usuário
     */
    String tenantName;

    /**
     * Localidade do tenant do usuário
     */
    String tenantLocale;

    /**
     * Indica se o usuário está bloqueado
     */
    Boolean blocked;

    /**
     * Tipo de autenticação utilizada pelo tenant deste usuário
     */
    AuthType authenticationType;

    /**
     * Indica se o usuário precisa trocar de senha no próximo logon
     */
    Boolean changePassword;

    /**
     * Foto do usuário em Base64
     */
    String photo;

    /**
     * Lista com as propriedades que este usuário possui (opcional)
     */
    List properties;

    /**
     * Indica se o usuário é um admin de tenant
     */
    Boolean admin;

    /**
     * Indica se o usuário pode alterar a sua senha.
     * É possível alterar a senha quando o tipo de autenticação do tenant é G7 ou quando é G5 e o tenant está configurado para permitir alterar a senha pela G7.
     */
    Boolean allowedToChangePassword;

    /**
     * @param id                      - Identificador do usuário
     * @param username                - Nome do usuário
     * @param fullName                - Nome completo do usuário
     * @param email                   - Endereço de e-mail do usuário
     * @param tenantDomain            - Domínio do tenant no login do usuário
     * @param tenantName              - Nome do tenant do usuário
     * @param tenantLocale            - Localidade do tenant do usuário
     * @param blocked                 - Indica se o usuário está bloqueado
     * @param authenticationType      - Tipo de autenticação utilizada pelo tenant deste usuário
     * @param photo                   - Foto do usuário em Base64
     * @param admin                   - Indica se o usuário é um admin de tenant
     * @param allowedToChangePassword - Indica se permite o usuário trocar de senha no próximo logon
     */
    public GetUserOutput(String id, String username, String fullName, String email, String tenantDomain, String tenantName, String tenantLocale, Boolean blocked, AuthType authenticationType, String photo, Boolean admin, Boolean allowedToChangePassword) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.tenantDomain = tenantDomain;
        this.tenantName = tenantName;
        this.tenantLocale = tenantLocale;
        this.blocked = blocked;
        this.authenticationType = authenticationType;
        this.photo = photo;
        this.admin = admin;
        this.allowedToChangePassword = allowedToChangePassword;
    }

    /**
     * Construtor
     *
     * @param tenantName - Nome do tenant
     */
    public GetUserOutput(String tenantName) {
        this.tenantName = tenantName;
    }

}
