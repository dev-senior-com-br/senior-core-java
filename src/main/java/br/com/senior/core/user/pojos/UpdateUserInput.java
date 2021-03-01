package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * Payload de entrada do {@link br.com.senior.core.user.UserClient#updateUser(UpdateUserInput) updateUser}
 */
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateUserInput {

    /**
     * Nome do usuário
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
     * Descrição do usuário
     */
    String description;
    /**
     * Idioma preferêncial do usuário
     */
    String locale;
    /**
     * Foto do usuário em Base64
     */
    String photo;
    /**
     * Indica se o usuário está bloqueado
     */
    Boolean blocked;
    /**
     * Indica se o usuário precisa trocar de senha no próximo logon
     */
    Boolean changePassword;
    /**
     * Lista com as propriedades que este usuário possui (opcional)
     */
    List<Property> properties;
}
