# Senior API SDK para Java

Esta biblioteca permite desenvolvedores criar integrações das APIs da Senior.

## Instalação

### Usando Maven
1. Executar `mvn clean install`, após a execução do comando Senior API SDK para Java estará instalado no repositório local do maven.

2. Adicionar a dependência Senior Core no pom.xml do seu projeto

  ```xml
    ...
    <dependencies>
        <dependency>
            <groupId>br.com.senior</groupId>
            <artifactId>senior-core-java</artifactId>
            <version>2.0.0</version>
        </dependency>
    </dependencies>
    ...
  ```
3. Para obter a última versão da SDK verifique no repositório. https://mvnrepository.com/artifact/br.com.senior/senior-core-java

### Ambiente

Atualmente o ambiente padrão para o desenvolvimento é o da **Homologx**.
Para fazer a troca do ambiente basta chamar o construtor da api passando um dos Environments configurados:

```java
public enum Environment {

    PROD("https://api.senior.com.br"),
    HOMOLOG("https://platform-homologx.senior.com.br/t/senior.com.br/bridge/1.0");

    private final String url;

    Environment(String url) {
        this.url = url;
    }
}
```

## Exemplo Rápido

Implementamos no pacote **/examples/src/main/java/br/com/senior/core/examples/** um conjunto de classes de examplos para cada serviço. Alguns serviços dependem de variáveis que precisam ser informadas pelos usuários, como login e senha para testar o login, ou token de acesso para os testes de autorização.
Testes de login multi-fator por exemplo dependem de um usuário que esteja configurado dessa para tal.

O ambiente pode ser definido no construtor de cada client, por padrão é utilizado o ambiente de homologação.

Os exemplos são implementações funcionais, basta copiar o código do exemplo que se deseja para sua aplicação.

Utilizando como exemplo o login, caso a aplicação queira efetuar o login integrado com a Senior, basta adicionar a dependência no maven e utilizar o cliente de autenticação, por exemplo:

```java
    ...
    final String username = "meu_usuario@dominio.com.br";
    final String password = "minha_senha";
    AuthenticationClient client = new AuthenticationClient();
    LoginOutput output = client.login(new LoginInput(username, password));
    ...
```

Para mudar o ambiente para produção é necessário informar o environment ao chamar o construtor do Client:

```java
  AuthenticationClient client = new AuthenticationClient(Environment.PROD);
```

### Exemplos implementados

- [Authentication](examples/src/main/java/br/com/senior/core/examples/authentication/AuthenticationExample.java)
- [Authorization](examples/src/main/java/br/com/senior/core/examples/authorization/AuthorizationExample.java)
- [Blob]()
- [Configuration]()
- [Entity]()
- [Notification](examples/src/main/java/br/com/senior/core/examples/notification/NotificationExample.java)
- [Tenant]()
- [Users]()

### Variáveis de ambiente:

```
#Propriedades obrigatórias para todos os tipos de autenticação
TENANT_DOMAIN=<dominio_do_tenant>
TENANT_NAME=<nome_do_tenant>

#Login
SENIOR_USERNAME=<usuario>
PASS=<senha_do_usuario>

#Login multifator 
USERNAME_MFA=<nome_do_usuario_multifactor>
PASSWORD_MFA=<senha_do_usuario_multifactor>

#Login de aplicativo
ACCESS_KEY=<chave_de_acesso>
SECRET=<secret_de_acesso>
```

### Entidades

Implementamos a parte de utilidades para entidades, para facilitar as requisições realizadas para as mesmas. Conforme exemplos abaixo:

Como realizar uma chamada rest de uma entidade:
```java
// O Objeto.class defini ao objeto da entidade que você deseja requisitar.
Objeto retorno = new EntitiesUtils<>(dominio, serviço, token de autenticação, Objeto.class).executeGet(entity_name, filter);

// Caso seja necessário utilizar a classe de filtro
String filter = new FilterBuilder().field("id").equals("123").build();
// O mesmo terá como retorno o seguinte : ?filter=id eq 123
```

## [Guia de contribuição](https://dev.senior.com.br/guia-de-contribuicao/)

## Suporte

Criar um issue https://github.com/dev-senior-com-br/senior-core-java/issues

## License

Copyright © 2020.
