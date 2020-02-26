# Senior Authorization SDK para Java

Esta biblioteca permite desenvolvedores criar integrações do a API de Authorization / Authentication da Senior.

## Instalação

### Usando Maven
1. Executar `mvn clean install`, após a execução do comando Senior Authorization SDK para Java estará instalado no repositório local do maven.

2. Adicionar a dependência Senior Core no pom.xml do seu projeto

  ```xml
    ...
    <dependencies>
        <dependency>
            <groupId>br.com.senior</groupId>
            <artifactId>senior-core-java</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
    ...
  ```

3. Adicionar as seguintes variáveis de ambiente para realizar os testes:

  ```powershell
    ...
    USERNAME = "admin@xpto.com.br"
    PASSWORD = "minhasenha"
    ...
  ```

4. Escrever em linha de comando `mvn test -Dtest=**/*` para executar os testes integrados automatizados pelo Maven.

## Exemplo Rápido

Implementamos no pacote **/src/test/java/br/com/senior/core** um conjunto de testes de integração para cada serviço. Alguns serviços dependem de variáveis que precisam ser informadas pelos usuários, como login e senha para testar o login, ou token de acesso para os testes de autorização.
Testes de login multi fator por exemplo dependem de um usuário que esteja configurado dessa para tal.

O ambiente pode ser definido no construtor de cada client, por padrão é utilizado o ambiente de homologação.

Os  testes servem como exemplos de implementação, basta copiar o código do exemplo que se deseja para sua aplicação

Utilizando como exemplo o login, caso a aplicação queira efetuar o login integrado com a Senior, basta adicionar a dependência no maven e utilizar o cliente de autenticação, por exemplo

```java
    ...
    final String username = "meu_usuario@dominio.com.br";
    final String password = "minha_senha";
    AuthenticationClient client = new AuthenticationClient();
    LoginOutput output = client.login(new LoginInput(username, password));
    ...
```

### Suporte

1. Criar um issue https://github.com/dev-senior-com-br/authorization-java/issues
