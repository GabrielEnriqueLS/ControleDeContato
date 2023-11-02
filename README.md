# API Rest para Gerenciamento de Cadastro de Pessoas e Contatos

Esta API foi desenvolvida para permitir o gerenciamento de um sistema de cadastro de Pessoas e seus respectivos Contatos, oferecendo operações CRUD (Criar, Ler, Atualizar, Deletar) para ambas as entidades. Cada Pessoa pode ter múltiplos Contatos associados. O principal objetivo é fornecer endpoints para manipulação e gestão desses dados de maneira eficiente.

## Requisitos Técnicos

- **Linguagem e Framework**: Desenvolvida em Java utilizando Spring Boot (Versão 3.0.12) para garantir uma estrutura robusta e de fácil manutenção.
- **Persistência de Dados**: Utiliza JPA/Hibernate para a persistência de dados, com suporte ao banco de dados MySQL, seguindo as boas práticas e conceitos aprendidos em aula/exemplo.
- **Validações e Tratamento de Dados**: Implementação de tratamento de dados de entrada e validações necessárias para garantir a integridade e consistência dos dados.
- **Documentação da API**: Utilização da biblioteca OpenAPI (Swagger) para documentar e descrever todos os endpoints disponíveis, facilitando o entendimento e uso da API (xd).

## Endpoints Principais

A API oferece os seguintes endpoints principais para interação com as entidades de Pessoa e Contato:

### Pessoas 

- "Totalmente funcional(de alguma forma)"

- `GET /pessoas`: Recupera todas as pessoas cadastradas.
- `GET /pessoas/{id}`: Recupera uma pessoa específica pelo ID.
- `POST /pessoas`: Cria uma nova pessoa.
- `PUT /pessoas/{id}`: Atualiza os dados de uma pessoa existente.
- `DELETE /pessoas/{id}`: Remove uma pessoa do sistema.
  

  EXEMPLO
{
    "nome": "Exemplo Pessoa",
    "endereco": "Rua Exemplo, 123",
    "cep": "12345-678",
    "cidade": "Cidade Exemplo",
    "uf": "UF",
    "contatos": null
}


### Contatos

- 'Quebrado 01/11/2023' provavelmente a logica tambem esta errado.

- `GET /pessoas/{idPessoa}/contatos`: Recupera todos os contatos de uma pessoa específica.
- `GET /pessoas/{idPessoa}/contatos/{idContato}`: Recupera um contato específico de uma pessoa pelo ID.
- `POST /pessoas/{idPessoa}/contatos`: Adiciona um novo contato para uma pessoa.
- `PUT /pessoas/{idPessoa}/contatos/{idContato}`: Atualiza os dados de um contato associado a uma pessoa.
- `DELETE /pessoas/{idPessoa}/contatos/{idContato}`: Remove um contato de uma pessoa.

## Como Usar

Para começar a utilizar a API, siga estes passos:

1. **Instalação e Configuração do Ambiente**
   - Certifique-se de ter o Java e o MySQL configurados em seu ambiente.
   - Faça o download do código-fonte da API.
   - Configure as informações de conexão com o banco de dados no arquivo de propriedades do Spring Boot.

2. **Execução da API**
   - Execute a aplicação Spring Boot.
   - Os endpoints estarão disponíveis em `http://localhost:8080/api/XXXX`.

3. **Documentação da API**
   - (Tambem esta incompleta)
   - Acesse `http://localhost:8080/api/swagger-ui.html` para explorar e entender os endpoints disponíveis.

5. **Interagir com a API**
   - Utilize um software de sua preferência (ex: Postman) para enviar requisições para os endpoints e gerenciar os dados de Pessoas e Contatos.

## Conclusão

Esta API foi desenvolvida para fornecer um sistema de gerenciamento de Pessoas e seus Contatos, com suporte às operações CRUD, seguindo boas práticas de desenvolvimento(XD) e padrões de documentação estabelecidos pela OpenAPI (Swagger)(XD 2).

**Observação**: Certifique-se de usa no MySQL `create database controle;` para que o projeto funcione, ele tambem esta configurado para caso a aplicaçao seja encerrada ele vai derrubar a database.
