package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Informações básicas de uma usuário
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupBasicUser {

    /**
     * Nome do Usuário
     */
    public String username;
    /**
     * Nome completo do usuário
     */
    public String fullName;
    /**
     * Endereço de e-mail do usuário
     */
    public String email;
    /**
     * Indica se o usuário está bloqueado
     */
    public Boolean blocked;
    /**
     * Tipo de autenticação utilizada pelo usuário
     */
    public AuthType authenticationType;

}
