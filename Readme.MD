# Gerenciamento de Fornecedores, Produtos e Clima API

## Descrição

Esta aplicação em **Spring Boot** realiza o gerenciamento de fornecedores e produtos de forma reativa e relacional, utilizando **Spring Data JDBC** para o gerenciamento de fornecedores e **Spring WebFlux** junto com **Spring Data R2DBC** para a gestão de produtos. A aplicação expõe APIs para realizar operações CRUD (criação, leitura, atualização e exclusão) para ambas as entidades.

### Tecnologias Utilizadas

- **Spring Boot**
- **Spring WebFlux**
- **Spring Data JDBC**
- **Spring Data R2DBC**
- **H2 Database** (para testes com Fornecedor)
- **PostgreSQL** (ou qualquer outro banco de dados compatível com R2DBC para o serviço de Produto)
- **WebClient** (para consumo de APIs externas)

## Funcionalidades

### Entidade Fornecedor (Spring Data JDBC)

A aplicação permite o gerenciamento de fornecedores com operações:

- **Criar**: Adicionar um novo fornecedor.
- **Atualizar**: Atualizar um fornecedor existente.
- **Excluir**: Remover um fornecedor da base de dados.
- **Listar**: Exibir todos os fornecedores cadastrados.
- **Buscar por ID**: Exibir um fornecedor específico.

### Entidade Produto (Spring WebFlux + Spring Data R2DBC)

A aplicação também permite o gerenciamento de produtos de forma reativa com operações:

- **Criar**: Adicionar um novo produto.
- **Atualizar**: Atualizar um produto existente.
- **Excluir**: Remover um produto da base de dados.
- **Listar**: Exibir todos os produtos cadastrados.
- **Buscar por ID**: Exibir um produto específico.

## Endpoints

### Fornecedor

- **Criar Fornecedor**: `POST /fornecedores`
  - Corpo da requisição: 
    ```json
    {
      "nome": "Fornecedor Exemplo",
      "endereco": "Rua Exemplo, 123"
    }
    ```
  
- **Atualizar Fornecedor**: `PUT /fornecedores/{id}`
  - Corpo da requisição:
    ```json
    {
      "nome": "Fornecedor Atualizado",
      "endereco": "Rua Atualizada, 456"
    }
    ```

- **Excluir Fornecedor**: `DELETE /fornecedores/{id}`

- **Listar Fornecedores**: `GET /fornecedores`

- **Buscar Fornecedor por ID**: `GET /fornecedores/{id}`

### Produto

- **Criar Produto**: `POST /produtos`
  - Corpo da requisição:
    ```json
    {
      "nome": "Produto Exemplo",
      "preco": 99.99
    }
    ```

- **Atualizar Produto**: `PUT /produtos/{id}`
  - Corpo da requisição:
    ```json
    {
      "nome": "Produto Atualizado",
      "preco": 199.99
    }
    ```

- **Excluir Produto**: `DELETE /produtos/{id}`

- **Listar Produtos**: `GET /produtos`

- **Buscar Produto por ID**: `GET /produtos/{id}`

## Setup do Projeto

### Requisitos

- **Java 17+**
- **Maven** (ou outra ferramenta de build)
- **Banco de Dados**:
  - **H2 Database** (pré-configurado para a entidade Fornecedor).
  - **PostgreSQL** (ou outro banco compatível com R2DBC para a entidade Produto).

### Configuração do Banco de Dados

- A aplicação usa **H2 Database** para a entidade **Fornecedor** (não necessita configuração adicional).
- Para o **PostgreSQL** (ou outro banco) na entidade **Produto**, configure as propriedades de conexão no arquivo `application.yml`:

```yaml
spring:
  r2dbc:
    url: r2dbc:postgresql://localhost:5432/produto_db
    username: postgres
    password: password
```

### Rodando a Aplicação

1. Clone o repositório:
   ```bash
   git clone https://github.com/FabioPelagaggi/TP3-Microsservicos.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd sua-aplicacao
   ```

3. Compile o projeto e baixe as dependências:
   ```bash
   mvn clean install
   ```

4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

A aplicação estará disponível em: `http://localhost:8080`.

### Testando a Aplicação

Você pode testar os endpoints usando o **Postman**, **cURL**, ou qualquer outro cliente HTTP.

Exemplo de requisição **cURL** para listar todos os fornecedores:
```bash
curl -X GET http://localhost:8080/fornecedores
```

## Consumo de API Externa (Clima)

A aplicação também inclui um cliente reativo usando **WebClient** para consumir uma API externa de clima. O serviço pode ser configurado no arquivo `ClimaService` com a chave da API:

```java
String apiKey = "SUA_CHAVE_API";  // Substitua pela sua chave de API
```

### Exemplo de Chamada da API de Clima

- **Buscar clima por cidade**: `GET /clima/{cidade}`

```bash
curl -X GET http://localhost:8080/clima/Sao%20Paulo
```

## Testes

A aplicação está configurada para utilizar o **Testcontainers** (não mostrado no código anterior) para realizar testes de integração reativos com um banco de dados Dockerizado. Para rodar os testes, utilize:

```bash
mvn test
```

## Licença

Este projeto está sob a licença [MIT](https://opensource.org/licenses/MIT). 

---

Com esse `README.md`, qualquer pessoa pode configurar, executar e utilizar a aplicação, além de entender suas funcionalidades e como interagir com ela.