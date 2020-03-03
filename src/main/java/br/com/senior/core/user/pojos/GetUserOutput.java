package br.com.senior.core.user.pojos;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;


@Getter
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
     * This constructor allows initialization of all fields, required and optional.
     */
    public GetUserOutput(String id, String username, String fullName, String description, String email, String locale, String tenantDomain, String tenantName, String tenantLocale, Boolean blocked, AuthType authenticationType, Boolean changePassword, String photo, java.util.List<Property> properties, Boolean admin, Boolean allowedToChangePassword) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.description = description;
        this.email = email;
        this.locale = locale;
        this.tenantDomain = tenantDomain;
        this.tenantName = tenantName;
        this.tenantLocale = tenantLocale;
        this.blocked = blocked;
        this.authenticationType = authenticationType;
        this.changePassword = changePassword;
        this.photo = photo;
        this.properties = properties;
        this.admin = admin;
        this.allowedToChangePassword = allowedToChangePassword;
    }

    /**
     * This convenience constructor allows initialization of all required fields.
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

    public GetUserOutput() {
    }

    public GetUserOutput(String tenantName) {
        this.tenantName = tenantName;
    }

}
