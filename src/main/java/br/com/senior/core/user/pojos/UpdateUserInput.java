package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateUserInput {

    /**
     * Nome do usuário
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
     * Descrição do usuário
     */
    public String description;
    /**
     * Idioma preferêncial do usuário
     */
    public String locale;
    /**
     * Foto do usuário em Base64
     */
    public String photo;
    /**
     * Indica se o usuário está bloqueado
     */
    public Boolean blocked;
    /**
     * Indica se o usuário precisa trocar de senha no próximo logon
     */
    public Boolean changePassword;
    /**
     * Lista com as propriedades que este usuário possui (opcional)
     */
    public java.util.List<Property> properties;
}
