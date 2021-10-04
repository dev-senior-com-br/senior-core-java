package br.com.senior.core.configuration.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListServicePropertiesInput {

    /**
     * Se informado, somente com este domínio específico
     */
    private String dominio;
    /**
     * Se informado, somente com este serviço específico
     */
    private String servico;

}
