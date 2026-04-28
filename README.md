
```markdown
# 📌 Prova Backend - API com JWT

Este projeto implementa uma API REST em Java com Spring Boot, utilizando autenticação JWT.  
A API permite **registro e login de usuários**, criação e listagem de **posts**, além de **comentários** vinculados a cada post.

---

## 🚀 Configuração e Execução

1. Clone o repositório:
   ```bash
   git clone <url-do-repo>
   ```
2. Configure o banco de dados MySQL no `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/provabackend
   spring.datasource.username=root
   spring.datasource.password=senha
   api.security.token.secret=algumasecretaforte
   ```
3. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```
4. A API estará disponível em:
   ```
   http://localhost:8080
   ```

---

## 🔑 Autenticação JWT

- Após o login, um token JWT é gerado.
- Esse token deve ser enviado em todas as requisições protegidas no header:
  ```
  Authorization: Bearer <token>
  ```

---

## 📌 Endpoints

### Usuários
- **POST /auth/register** → registra novo usuário
- **POST /auth/login** → autentica e retorna token JWT

### Posts
- **POST /posts** → cria novo post (autenticado)
- **GET /posts** → lista todos os posts

### Comentários
- **POST /posts/{postId}/comments** → cria comentário em um post (autenticado)
- **GET /posts/{postId}/comments** → lista comentários de um post

---

## 🧪 Testando a API no Insomnia

### 1. Registro
```http
POST http://localhost:8080/auth/register
Content-Type: application/json

{
  "name": "Davi",
  "email": "davi@email.com",
  "password": "123456"
}
```

### 2. Login
```http
POST http://localhost:8080/auth/login
Content-Type: application/json

{
  "email": "davi@email.com",
  "password": "123456"
}
```
Resposta:
```json
{ "token": "jwt-gerado" }
```

### 3. Criar Post
```http
POST http://localhost:8080/posts
Authorization: Bearer <token>
Content-Type: application/json

{
  "title": "Meu primeiro post",
  "content": "Conteúdo do post"
}
```

### 4. Listar Posts
```http
GET http://localhost:8080/posts
Authorization: Bearer <token>
```

### 5. Criar Comentário
```http
POST http://localhost:8080/posts/1/comments
Authorization: Bearer <token>
Content-Type: application/json

{
  "content": "Muito bom esse post!"
}
```

### 6. Listar Comentários
```http
GET http://localhost:8080/posts/1/comments
Authorization: Bearer <token>
```

---

## 🔮 Possíveis Melhorias Futuras
- Implementar edição e exclusão de posts e comentários.
- Adicionar paginação nas listagens.
- Criar sistema de roles (admin, user).

---

## 👨‍💻 Autor
Projeto desenvolvido por **Davi** como parte da prova de backend.


