# Sistema de Gerenciamento de Usuários

Este é um sistema CRUD (Create, Read, Update, Delete) desenvolvido em Java utilizando JSP (JavaServer Pages) para gerenciamento de usuários.

## Tecnologias Utilizadas

- Java
- JSP (JavaServer Pages)
- Struts 2
- MySQL (Banco de Dados)
- Maven (Gerenciamento de Dependências)

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
└── webapp/
    ├── WEB-INF/
    │   ├── web.xml    # Configuração do servlet
    │   └── struts.xml # Configuração do Struts 2
    └── *.jsp          # Páginas JSP
```

## Funcionalidades

- Listagem de usuários
- Cadastro de novos usuários
- Edição de usuários existentes
- Exclusão de usuários
- Visualização detalhada de usuários

## Modelo de Dados

O sistema trabalha com a entidade Usuário que possui os seguintes atributos:
- ID (Long)
- Nome (String)
- Email (String)

## Como Executar

1. Clone o repositório
2. Configure o banco de dados MySQL
3. Execute o projeto em um servidor Java EE (como Tomcat)
4. Acesse a aplicação através do navegador

## Requisitos

- Java JDK 8 ou superior
- Maven 3.x
- MySQL 5.7 ou superior
- Servidor Java EE (Tomcat 8.x ou superior)

## Configuração do Banco de Dados

- Crie as tabelas necessárias antes de subir a aplicação, os scripts estão em ```src\main\resources\schema.sql```