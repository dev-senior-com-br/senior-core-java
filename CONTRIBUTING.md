# Senior Authorization SDK para Java

## Testes automatizados

Para executar os testes automatizados é necessário configurar algumas variáveis de ambientes.

### Variáveis de ambiente

  ```powershell
    ...
    username = admin@xpto.com.br;
    password_invalid = minhasenhainvalida;
    password_valid = minhasenhavalida;
    username_mfa = usernamemfa;
    password_mfa = passwordmfa;    
    secret = password;
    access_key = minhaaccesskeyc51b1e661baa2bd2ef48b78391febba2; 
    tenant = xpto;
    ...
  ```

OBS: Para executar os testes integrados automatizados pelo Maven executar o comando `mvn test -Dtest=**/*` .