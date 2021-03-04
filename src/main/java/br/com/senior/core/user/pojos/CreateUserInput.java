package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de entrada do {@link br.com.senior.core.user.UserClient#createUser(CreateUserInput) createUser}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserInput {

    /**
     * Nome (username) do usuário
     */
    String username;
    /**
     * Nome completo do usuário
     */
    String fullName;
    /**
     * Endereço de e-mail do usuário
     */
    String email;
    /**
     * Senha do usuário
     */
    String password;
    /**
     * Descrição do usuário (opcional)
     */
    String description;
    /**
     * Indica se o usuário está ou não bloqueado
     */
    Boolean blocked;
    /**
     * Indica se o usuário precisa trocar a senha no próximo logon
     */
    Boolean changePassword;
    /**
     * Foto do usuário, em Base64. (opcional)
     */
    String photo;
    /**
     * Localidade do usuário
     */
    String locale;
    /**
     * Lista com as propriedades que este usuário possui (opcional)
     */
    List<Property> properties;

}
