
---

```markdown
# 📌 Prova Backend - API com Spring Boot e JWT

Este projeto é uma API REST desenvolvida em **Spring Boot** com autenticação via **JWT**.  
O objetivo é implementar um CRUD de posts com segurança e documentação básica.

---

## 🚀 Como executar o projeto

### Pré-requisitos
- **Java 17+**
- **Maven**
- **Banco de dados** (H2 em memória ou PostgreSQL/MySQL, conforme configuração)

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/prova-backend.git
   ```
2. Entre na pasta do projeto:
   ```bash
   cd prova-backend
   ```
3. Configure o arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update

   api.security.token.secret=meuSegredoJWT
   ```
4. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```
5. Acesse a API em:
   ```
   http://localhost:8080
   ```

---

## 📌 Endpoints disponíveis

### Autenticação
- **POST /auth/register**  
  Request:
  ```json
  {
    "name": "Davi",
    "email": "usuario@email.com",
    "password": "123456"
  }
  ```
  Response:
  ```json
  {
    "id": 1,
    "name": "Davi",
    "email": "usuario@email.com"
  }
  ```

- **POST /auth/login**  
  Request:
  ```json
  {
    "email": "usuario@email.com",
    "password": "123456"
  }
  ```
  Response:
  ```json
  {
    "token": "jwt-gerado"
  }
  ```

### Posts
- **POST /posts** (criar post)  
  Header: `Authorization: Bearer <token>`  
  Request:
  ```json
  {
    "title": "Meu primeiro post",
    "content": "Conteúdo do post"
  }
  ```
  Response:
  ```json
  {
    "id": 1,
    "title": "Meu primeiro post",
    "content": "Conteúdo do post",
    "userEmail": "usuario@email.com"
  }
  ```

- **GET /posts** (listar posts)  
  Response:
  ```json
  [
    {
      "id": 1,
      "title": "Meu primeiro post",
      "content": "Conteúdo do post",
      "userEmail": "usuario@email.com"
    }
  ]
  ```

- **PUT /posts/{id}** (atualizar post)  
  Request:
  ```json
  {
    "title": "Post atualizado",
    "content": "Novo conteúdo"
  }
  ```
  Response:
  ```json
  {
    "id": 1,
    "title": "Post atualizado",
    "content": "Novo conteúdo",
    "userEmail": "usuario@email.com"
  }
  ```

- **DELETE /posts/{id}** (remover post)  
  Response: `204 No Content`

---

## 🔑 Autenticação JWT

- O login gera um **token JWT** válido por **2 horas**.
- O token deve ser enviado no header de cada requisição protegida:
  ```
  Authorization: Bearer <token>
  ```
- O token contém:
    - `sub`: email do usuário
    - `id`: id do usuário
    - `iss`: "auth-api"
    - `exp`: data de expiração

---

## 💡 Possíveis melhorias futuras

- Implementar **DTOs** para separar entidades do contrato da API.
- Adicionar **Swagger/OpenAPI** para documentação interativa.
- Criar **testes automatizados** (unitários e de integração).
- Melhorar tratamento de erros com mensagens padronizadas.
- Adicionar paginação e ordenação na listagem de posts.

---

## 📌 Autor
Projeto desenvolvido por **Davi** como parte da prova de backend.
```

