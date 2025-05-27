# JSP CRUD - Sistema de Gerenciamento de Usuários

Sistema CRUD (Create, Read, Update, Delete) desenvolvido com Java Web, utilizando Struts 2, JSP, Bootstrap 5, PostgreSQL e JDBC puro.

## 🚀 Tecnologias Utilizadas

- Java 8
- Struts 2 (Framework MVC)
- JSP (View)
- Bootstrap 5 (UI Framework)
- PostgreSQL (Banco de Dados)
- JDBC (Acesso ao Banco de Dados)
- Maven (Gerenciador de Dependências)
- Lombok (Redução de código boilerplate)

## 📋 Funcionalidades

- Listagem de Usuários
- Cadastro de Novo Usuário
- Edição de Usuário
- Exclusão de Usuário
- Validações (Frontend e Backend)
- Tratamento de Erros
- Interface Responsiva

## 🛠️ Pré-requisitos

- JDK 8
- Maven 3.6+
- PostgreSQL 12+
- Apache Tomcat 9+

## 🔧 Configuração do Ambiente

1. Clone o repositório:
```bash
git clone [URL_DO_REPOSITÓRIO]
cd jsp-crud
```

2. Configure o banco de dados PostgreSQL:

### Opção 1: Usando Docker (Recomendado)

1. Inicie o container do PostgreSQL:
```bash
docker-compose up -d
```

2. O banco de dados estará disponível com as seguintes credenciais:
   - Host: localhost
   - Porta: 5432
   - Banco: jsp-studies
   - Usuário: postgres
   - Senha: postgres

3. Execute o script SQL para criar a tabela:
```bash
psql -h localhost -U postgres -d jsp-studies -f src/main/resources/schema.sql
```

### Opção 2: Instalação Manual do PostgreSQL

1. Instale o PostgreSQL 12+
2. Crie o banco de dados:
```sql
CREATE DATABASE "jsp-studies";
```

3. Execute o script SQL para criar a tabela:
```bash
psql -h localhost -U postgres -d jsp-studies -f src/main/resources/schema.sql
```

## 🚀 Executando a Aplicação

1. Compile o projeto:
```bash
mvn clean install
```

2. Copie o arquivo WAR gerado em `target/jsp-crud.war` para a pasta `webapps` do Tomcat

3. Inicie o Tomcat:
```bash
# Windows
%CATALINA_HOME%\bin\startup.bat

# Linux/Mac
$CATALINA_HOME/bin/startup.sh
```

4. Acesse a aplicação:
```
http://localhost:8080/jsp-crud
```

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── br.com.matheushramos/
│   │       ├── action/         (Struts Actions)
│   │       ├── service/        (Lógica de negócio)
│   │       ├── dao/           (Data Access Objects)
│   │       ├── model/         (Entidades)
│   │       └── util/          (Utilitários)
│   ├── resources/
│   │   └── schema.sql        (Script de criação da tabela)
│   └── webapp/
│       ├── WEB-INF/
│       │   ├── web.xml
│       │   ├── struts.xml
│       │   └── jsp/
│       │       ├── listaUsuarios.jsp
│       │       └── cadastroUsuario.jsp
```

## 📝 Notas

- A aplicação utiliza JDBC puro para acesso ao banco de dados
- O modo de desenvolvimento do Struts 2 está ativado para facilitar o debug
- As mensagens de erro são exibidas em modais Bootstrap
- A validação é feita tanto no frontend quanto no backend
- O banco de dados pode ser executado via Docker ou instalado localmente
- Uso de try-with-resources para garantir o fechamento automático de recursos JDBC
- Implementação do padrão DAO (Data Access Object) para acesso ao banco de dados
- Conexão com o banco de dados centralizada na classe ConnectionFactory
- Uso do Lombok para reduzir código boilerplate nas classes de modelo

## 🔄 Comandos Docker Úteis

```bash
# Iniciar o banco de dados
docker-compose up -d

# Parar o banco de dados
docker-compose down

# Ver logs do container
docker-compose logs -f

# Remover todos os dados (incluindo volume)
docker-compose down -v
```

## 🤝 Contribuindo

1. Faça o fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes. 