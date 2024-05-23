# Política de Segurança

## Relatando Vulnerabilidades de Segurança

Na Opengotchi, levamos a segurança muito a sério. Se você descobrir alguma vulnerabilidade de segurança, solicitamos que nos informe o mais rápido possível para que possamos tomar as medidas necessárias para resolver o problema. Siga as diretrizes abaixo para relatar vulnerabilidades de segurança:

### Como Relatar uma Vulnerabilidade

1. **Seção de Issue**
   - Descreva a natureza da vulnerabilidade.
   - Forneça detalhes completos sobre como reproduzir a vulnerabilidade.
   - Inclua qualquer informação adicional que possa nos ajudar a entender a extensão e o impacto da vulnerabilidade.

2. **Confidencialidade**
   - Por favor, trate o relatório com confidencialidade. Não divulgue informações sobre a vulnerabilidade publicamente até que tenhamos tido a chance de investigá-la e lançar uma correção.

3. **Agradecimentos**
   - Agradecemos sua contribuição para a segurança do nosso projeto. Nos comprometemos a reconhecer publicamente os esforços dos pesquisadores que relataram vulnerabilidades de forma responsável, uma vez que o problema tenha sido resolvido.

### Dependências e Segurança

Nosso projeto utiliza diversas bibliotecas e frameworks, conforme especificado no arquivo `pom.xml`. Garantir a segurança dessas dependências é crucial. Veja a seguir algumas práticas de segurança relacionadas às dependências:

- **Spring Boot**:
  - Versão: 3.1.11
  - Dependências: `spring-boot-starter-data-jpa`, `spring-boot-starter-web`, `spring-boot-devtools`, `spring-boot-starter-test`

- **Banco de Dados**:
  - Dependência: `com.h2database:h2`
  - Uso: Runtime, principalmente para desenvolvimento e testes.

- **Lombok**:
  - Dependência: `org.projectlombok:lombok`
  - Uso: Opcional, excluída do build final para evitar qualquer impacto em runtime.

### Boas Práticas de Segurança

1. **Mantenha as Dependências Atualizadas**
   - Monitore regularmente as dependências para novas versões e patches de segurança.
   - Use ferramentas como `Dependabot` ou `Snyk` para ajudar a gerenciar atualizações de dependências e identificar vulnerabilidades conhecidas.

2. **Desabilitar DevTools em Produção**
   - A dependência `spring-boot-devtools` deve ser usada apenas em ambientes de desenvolvimento. Assegure-se de que está excluída de builds de produção.

3. **Banco de Dados Seguro**
   - A dependência `H2` deve ser usada principalmente para desenvolvimento. Para produção, use um banco de dados robusto e seguro com práticas recomendadas de segurança de dados.

4. **Testes de Segurança**
   - Inclua testes de segurança como parte do pipeline de CI/CD para detectar vulnerabilidades antecipadamente.
   - Utilize ferramentas de análise estática de código para identificar possíveis falhas de segurança.

### Responsabilidade de Aplicação

Os líderes da comunidade são responsáveis por revisar e resolver relatórios de segurança. Comprometemo-nos a responder aos relatórios de vulnerabilidades no prazo de uma semana e a lançar correções necessárias o mais rápido possível.
