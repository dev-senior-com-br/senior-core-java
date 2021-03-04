package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de saída do {@link br.com.senior.core.user.UserClient#getUser(GetUserInput) getUser}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
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
     * Dados do usuário integrado pela G5, mas futuramente poderá ser utilizado para outras integrações se necessário
     */
    Integration integration;
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
    List<Property> properties;
    /**
     * Indica se o usuário é um admin de tenant
     */
    Boolean admin;
    /**
     * Indica se o usuário pode alterar a sua senha.
     * É possível alterar a senha quando o tipo de autenticação do tenant é G7 ou quando é G5 e o tenant está configurado para permitir alterar a senha pela G7.
     */
    Boolean allowedToChangePassword;

}
