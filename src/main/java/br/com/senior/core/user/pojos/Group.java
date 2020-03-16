package br.com.senior.core.user.pojos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 *
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group {

    /**
     * Identificador do Grupo
     */
    public String id;
    /**
     * Nome do Grupo
     */
    public String name;
    /**
     * Descrição do Grupo
     */
    public String description;
    /**
     * E-mail do grupo
     */
    public String email;

}
