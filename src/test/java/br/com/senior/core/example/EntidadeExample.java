package br.com.senior.core.example;

import br.com.senior.core.authentication.AuthenticationClient;
import br.com.senior.core.authentication.pojos.LoginInput;
import br.com.senior.core.authentication.pojos.LoginOutput;
import br.com.senior.core.base.ServiceException;
import br.com.senior.core.entities.EntitiesUtils;
import br.com.senior.core.entities.EntityPage;
import br.com.senior.core.entities.FilterBuilder;
import br.com.senior.core.example.pojos.Syndicate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EntidadeExample {

    public static void main(String[] args) throws ServiceException {

        final String username = System.getenv("SENIOR_USERNAME");
        final String password = System.getenv("PASS");
        final String ENTITY_NAME = "syndicate";

        Syndicate syndicate;
        Syndicate syndicateResult;
        EntityPage<Syndicate> entityPage;

        //Autenticação
        AuthenticationClient client = new AuthenticationClient();
        LoginOutput output = client.login(LoginInput.builder().username(username).password(password).build());
        String token = output.getJsonToken().getAccessToken();
        log.info(token);

        //POST
        EntitiesUtils entityUtils = new EntitiesUtils<>("hcm", "payroll", token, Syndicate.class);
        syndicate = new Syndicate("4ca94ee8-a1c2-11ea-bb37-0242ad", 2L, "Nome do Sindicato", 12L);
        syndicateResult = (Syndicate) entityUtils.executePost(ENTITY_NAME, syndicate);
        log.info(syndicateResult.toString());

        //GET
        entityPage = entityUtils.executeGet(ENTITY_NAME, null);
        log.info("Array com " + entityPage.getTotalElements() + " entidades");

        //GetById
        syndicateResult = (Syndicate) entityUtils.executeGetById(ENTITY_NAME, "4ca94ee8-a1c2-11ea-bb37-0242ad");
        log.info(syndicateResult.toString());

        //GET com Filter
        String filter = new FilterBuilder().field("id").equals("4ca94ee8-a1c2-11ea-bb37-0242ad").build();
        entityPage = new EntitiesUtils<>("hcm", "payroll", token, Syndicate.class).executeGet("syndicate", filter);

        //PUT
        Syndicate payload = new Syndicate("4ca94ee8-a1c2-11ea-bb37-0242ad", 2L, "Sindicato de tudo", 12L);
        syndicateResult = (Syndicate) entityUtils.executePut(ENTITY_NAME, "4ca94ee8-a1c2-11ea-bb37-0242ad", payload);
        log.info(syndicateResult.toString());

        //Delete
        entityUtils.executeDelete(ENTITY_NAME, "4ca94ee8-a1c2-11ea-bb37-0242ad");

    }

}
