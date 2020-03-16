package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

/**
 * Payload de entrada do {@link br.com.senior.core.user.UserClient#createUser(CreateUserInput) createUser}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserInput {

    /**
     * Nome (username) do usuário
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
     * Senha do usuário
     */
    public String password;
    /**
     * Descrição do usuário (opcional)
     */
    public String description;
    /**
     * Indica se o usuário está ou não bloqueado
     */
    public Boolean blocked;
    /**
     * Indica se o usuário precisa trocar a senha no próximo logon
     */
    public Boolean changePassword;
    /**
     * Foto do usuário, em Base64. (opcional)
     */
    public String photo;
    /**
     * Localidade do usuário
     */
    public String locale;
    /**
     * Lista com as propriedades que este usuário possui (opcional)
     */
    public java.util.List<Property> properties;

}
