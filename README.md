# Opengotchi 👾
Uma versão de código aberto e baseada em API do clássico bichinho virtual: [Tamagotchi](https://pt.wikipedia.org/wiki/Tamagotchi).

![Opengotchi Logo](https://github.com/Navelogic/Opengotchi/assets/93350805/bcc11acf-9a49-4b90-ab16-edd86819bc8f)

## Visão Geral
**Opengotchi** permite que desenvolvedores integrem um bichinho virtual em qualquer sistema conectado à internet, como Telegram, Discord, WhatsApp, CLI, sites e projetos pessoais.

## Princípios
- **Código Aberto:** Licenciado sob a Licença MIT, permitindo uso, modificação e distribuição livre.
- **API:** Interaja com o bichinho virtual através de endpoints RESTful.
- **WEB:** Em breve!
- **WORA:** Escreva uma vez, rode em qualquer lugar.

## Contribuindo
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests no repositório.

### Como Contribuir
1. Crie uma branch para sua alteração.
2. Commit suas mudanças.
3. Push para a branch `main`.
4. Abra um Pull Request.
5. Aguarde feedback.

[Guia de Contribuição Detalhado](https://github.com/Navelogic/Opengotchi/blob/main/CONTRIBUTING.md)

### Bugs ou Novatos em Programação?
Não se preocupe! Você pode contribuir reportando bugs ou sugerindo melhorias: [Clique aqui](https://github.com/Navelogic/Opengotchi/issues/new/choose).

## Rodando Localmente
Para rodar o Opengotchi localmente, você precisará do Java 17 e do Spring Boot 3. Siga os passos abaixo:

1. Clone o repositório: `git clone https://github.com/Navelogic/Opengotchi.git`.
2. Navegue até o diretório: `cd Opengotchi`.
3. Inicie a aplicação: 
   - Para macOS/Linux: `./mvnw spring-boot:run`
   - Para Windows: `mvnw spring-boot:run`.
4. Acesse o servidor local em `http://localhost:8080`.

Verifique o arquivo `application-dev.properties` para configurar o acesso ao banco de dados MySQL e consulte a documentação da API no diretório `API` do repositório para mais detalhes sobre como interagir com o Opengotchi.

## Diário do Desenvolvedor
Navelogic (autor deste documento) compartilha o processo de criação da API no Reddit. Confira os posts: [Estou criando o próximo Tamagotchi.](https://www.reddit.com/r/brdev/comments/1fqv8br/estou_criando_o_pr%C3%B3ximo_tamagotchi/)

## Licença
Este projeto é licenciado sob a Licença MIT. Veja o arquivo [LICENSE](https://github.com/Navelogic/Opengotchi/blob/main/LICENSE) para mais detalhes.
