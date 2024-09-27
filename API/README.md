# Endpoints da API - Opengotchi (V1.0)

## Base URL
- **GET** /api/v1
    - Retorna uma mensagem de boas-vindas.
    - **Response**
        - **200 OK**
          ```json
            {
               "msg": "Olá, eu sou o OpenGotchi! É um prazer te conhecer!"
            }
          ```
## Ambiente
- **GET** /api/v1/environment
    - Retorna uma mensagem indicando o ambiente atual (desenvolvimento ou produção).
    - **Response**
        - **200 OK**
          ```json
          {
            "msg": "Você está no ambiente de desenvolvimento!"
          }
          ```
          ou
          ```json
          {
            "msg": "Você está no ambiente de produção!"
          }
          ```
## Usuário
- **GET** /api/v1/usuario
    - Retorna uma lista com informações básicas dos usuários da aplicação.
    - **Response**
        - **200 OK**
          ```json
          {
          "id": 1,
          "nome": "Bill Gates"
          },
          {
          "id": 2,
          "nome": "Mark Zuckerberg"
          }
          ```
- **GET** /api/v1/usuario/{id}
    - Retorna uma lista com informações públicas de um usuário da aplicação.
    - **Response**
        - **200 OK**
          ```json
          {
          "id": 1,
          "nome": "Bill Gates",
          "email": "flYepUYI5dAFeXxvk12AZZAmVQNKNf2mT3qD8jeaD7w=",
          "ultima_entrada": "2024-09-27T14:57:46.562865Z",
          "ultima_atualizacao": "2024-09-27T14:57:46.562865Z",
          "criado_em": "2024-09-27T14:57:46.562865Z"
          }
          ```
        - **404 NOT FOUND**
            ```json
          {
          "msg": "Usuário não encontrado com o id: {id}"
          }
          ```
- **GET** /api/v1/usuario/email/{email}
    - Retorna uma lista com informações públicas de um usuário da aplicação.
    - **Response**
        - **200 OK**
          ```json
          {
          "id": 1,
          "nome": "Bill Gates",
          "email": "flYepUYI5dAFeXxvk12AZZAmVQNKNf2mT3qD8jeaD7w=",
          "ultima_entrada": "2024-09-27T14:57:46.562865Z",
          "ultima_atualizacao": "2024-09-27T14:57:46.562865Z",
          "criado_em": "2024-09-27T14:57:46.562865Z"
          }
          ```
        - **404 NOT FOUND**
            ```json
          {
          "msg": "Usuário não encontrado com o email: {email}"
          }
          ```
- **POST** /api/v1/usuario
    - Cria um novo usuário na aplicação.
    - **Request**
        ```json
      {
      "nome" : "Mark Zuckerberg",
      "email": "zuck@fb.com",
      "senha": "iLoveElonM!"
      }
      ```
    - **Response**
        - **200 OK**
          ```json
          {
          "id": 1,
          "nome": "Mark Zuckerberg",
          "email": "uZS+VmYqZyGkUXYuhB3UEtUv60IV3SLQBvkWzhrqVVU=",
          "ultima_entrada": "2024-09-27T15:16:24.668005200Z",
          "ultima_atualizacao": "2024-09-27T15:16:24.668005200Z",
          "criado_em": "2024-09-27T15:16:24.668005200Z"
          }
          ```
        - **409 CONFLICT**
            ```json
          {
          "msg": "Usuário já existente com o email fornecido"
          }
          ```
    - **Request**
      ```json
      {
      "nome" : "Mark Zuckerberg",
      "email": "zuck@fb.com"
      }
      ```
  - **Response**
      - **400 BAD REQUEST**
        ```json
        {
        "msg": "Usuário faltando atributos obrigatórios"
        }
        ```
- **GET** /api/v1/usuario/login/{email}/{senha}
    - Retorna um long com o id do usuário que fez login.
    - **Response**
        - **200 OK**
          ```json
          {
          "id": 1
          }
          ```
        - **404 NOT FOUND**
            ```json
          {
          "msg": "E-mail ou senha incorretos"
          }
          ```
- **PUT** /api/v1/usuario/{id}
    - Atualiza as informações de um usuário existente com base no {id}.
    - **Request**
        ```json
      {
      "nome" : "Steve Jobs",
      "email": "steve@apple.com",
      "senha": "appleForever!"
      }
      ```
      Ou, se apenas alguns campos forem atualizados:
      ```json
      {
      "nome" : "Steve Jobs"
      }
        ```
    - **Response**
        - **200 OK**
          ```json
          {
          "id": 1,
          "nome": "Steve Jobs",
          "email": "bXhbjvbYgRkR1TloYUVBgtIn60NZh1Asf25wZpgh6lw=",
          "ultima_entrada": "2024-09-27T15:16:24.668005200Z",
          "ultima_atualizacao": "2024-09-27T15:45:35.668005200Z",
          "criado_em": "2024-09-27T15:16:24.668005200Z"
          }
          ```
        - **404 NOT FOUND**
            ```json
          {
          "msg": "Usuário não encontrado com o id: {id}"
          }
          ```
        - **409 CONFLICT**
            ```json
          {
          "msg": "Email já está em uso"
          }
          ```
        - **400 BAD REQUEST**
            ```json
          {
          "msg": "Usuário faltando atributos obrigatórios"
          }
          ```
- **DELETE** /api/v1/usuario/{id}
- Deleta um usuário existente com base no {id}.
- **Response**
    - **200 OK**
      ```json
      {
      "msg": "Usuário deletado com sucesso"
      }
      ```
    - **404 NOT FOUND**
        ```json
      {
      "msg": "Usuário não encontrado com o id: {id}"
      }
      ```