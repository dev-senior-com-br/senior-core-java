package br.com.senior.core.entity;

import br.com.senior.core.BaseExample;
import br.com.senior.core.base.ServiceException;
import br.com.senior.core.entity.pojos.Pessoa;

import org.apache.commons.lang3.RandomUtils;

/**
 * Exemplos de código do Serviço Entity
 */
public class EntityExample extends BaseExample {

    /**
     * Utilizando o {@link br.com.senior.core.entity.EntityClient EntityClient}
     *
     * @param args - Argumentos de linha de comando
     * @throws ServiceException - Erro tratado de serviço
     */
    public static void main(String[] args) throws ServiceException {

        // Login
        String accessToken = getAccessToken();

        EntityClient<Pessoa> entityClient = new EntityClient<>("erpx_fnd", "pessoa", accessToken, Pessoa.class);


        String entityName = "e001pes";
        Pessoa pessoaInput;
        Pessoa pessoaOutput;

        EntityPage<Pessoa> entityPage;


        // Post
        int codigo = RandomUtils.nextInt(900000000, 999999999);

        pessoaInput = Pessoa.builder()
                .nomeFantasia("Nome Fantasia")
                .cnpCpf("")
                .codPes(codigo)
                .nome("Nome" + codigo)
                .situacao("VA")
                .tipMer("VI")
                .tipo("VF")
                .excluido(false)
                .build();
        pessoaOutput = entityClient.post(entityName, pessoaInput);

        System.out.println("POST: " + pessoaOutput);


        // Get
        entityPage = entityClient.get(entityName);

        System.out.println("GET: " + entityPage.getContents());


        // GetWithFilter
        String filter = EntityFilter.builder()
                .field("nomPes")
                .equals(pessoaInput.getNome())
                .build();
        entityPage = entityClient.getWithFilter(entityName, filter);

        System.out.println("GetWithFilter: " + entityPage.getContents());
        String id = entityPage.getContents().stream().findFirst().get().getId();


        // GetById
        pessoaOutput = entityClient.getById(entityName, id);

        System.out.println("GetById: " + pessoaOutput);


        // Put
        pessoaInput = Pessoa.builder()
                .id(id)
                .nomeFantasia("Novo Nome Fantasia")
                .cnpCpf("")
                .codPes(codigo)
                .nome("Novo Nome" + codigo)
                .situacao("VA")
                .tipMer("VI")
                .tipo("VF")
                .build();
        pessoaOutput = entityClient.put(entityName, id, pessoaInput);

        System.out.println("Put: " + pessoaOutput);


        // Delete
        entityClient.delete(entityName, id);
    }
}
