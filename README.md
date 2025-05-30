# Sistema de Gerenciamento de Usuários

Este é um sistema CRUD (Create, Read, Update, Delete) desenvolvido em Java utilizando JSP (JavaServer Pages) para gerenciamento de usuários.

## Tecnologias Utilizadas

- Java 8
- JSP (JavaServer Pages)
- Struts 2
- PostgreSQL (Banco de Dados)
- Maven (Gerenciamento de Dependências)
- Docker (Containerização do Banco de Dados)
- Lombok (Redução de código boilerplate)
- JUnit 5 (Testes unitários)
- Gson (Manipulação de JSON)
- iText (Geração de PDF)
- SLF4J (Logging)

## Estrutura do Projeto

O projeto segue uma arquitetura em camadas:

```
src/main/
├── java/
│   └── br/com/matheushramos/
│       ├── action/    # Classes de controle (Actions)
│       ├── dao/       # Camada de acesso a dados
│       ├── model/     # Classes de modelo
│       ├── service/   # Camada de serviço
│       └── util/      # Classes utilitárias
├── resources/
│   └── struts.xml     # Configuração do Struts 2
└── webapp/
    ├── WEB-INF/
    │   └── web.xml    # Configuração do servlet
    └── *.jsp          # Páginas JSP
```

## Funcionalidades

- Listagem de usuários
- Cadastro de novos usuários
- Edição de usuários existentes
- Exclusão de usuários
- Visualização detalhada de usuários
- Geração de relatórios em PDF
- Exportação de dados em JSON

## Modelo de Dados

O sistema trabalha com a entidade Usuário que possui os seguintes atributos:
- ID (Long)
- Nome (String)
- Email (String)

## Como Executar

1. Clone o repositório
2. Inicie o banco de dados PostgreSQL usando Docker (docker-compose.yml):
   ```bash
   docker-compose up -d
   ```
3. Execute o projeto em um servidor Java EE (Tomcat 9)
4. Acesse a aplicação através do navegador

## Requisitos

- Java JDK 8
- Maven 3.x
- Docker e Docker Compose
- Servidor Java EE (Tomcat 8.x ou superior)