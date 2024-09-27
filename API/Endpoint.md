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