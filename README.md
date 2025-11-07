# Central de Acessos – Sistema de Gestão de Solicitações

Este projeto é uma API REST desenvolvida em **Spring Boot**, cujo objetivo é gerenciar o processo de solicitação de acesso de colaboradores a sistemas internos, permitindo que usuários solicitem acesso e administradores aprovem, neguem ou revoguem essas permissões.

---

## 🚀 Funcionalidades

| Função | Descrição |
|------|-----------|
| Cadastro de Usuários | Usuários possuem nome, e-mail, cargo, senha e papel (USER ou ADMIN). |
| Cadastro de Sistemas | Cada sistema possui nome, descrição e nível de criticidade (BAIXO, MÉDIO, ALTO). |
| Solicitação de Acesso | Usuário solicita acesso a um sistema, ficando com status **PENDENTE**. |
| Aprovação / Negação | Um usuário **ADMIN** pode aprovar ou negar a solicitação. |
| Revogação | Um acesso **já aprovado** pode ser revogado posteriormente pelo administrador. |
| Listagem de Solicitações | Permite visualizar solicitações em geral ou por usuário. |

---

## 🧱 Arquitetura do Projeto

O projeto segue boas práticas de organização, utilizando:

- **Controller** → Expõe os endpoints da API.
- **Service** → Contém a lógica de negócio.
- **Repository** → Comunicação com o banco de dados via Spring Data JPA.
- **DTOs** → Servem para transporte de dados de entrada e saída.
- **Entities** → Representam as tabelas na base de dados.

---

## 🗃️ Entidades Principais

### `Usuario`
| Campo | Tipo | Descrição |
|------|------|-----------|
| id_usuario | Integer | Identificador |
| nome | String | Nome do usuário |
| email | String | E-mail (utilizado para login) |
| cargo | String | Cargo do colaborador |
| senha | String (criptografada) | Senha do usuário |
| role | `USER` ou `ADMIN` | Define permissões |

### `Sistema`
| Campo | Tipo | Descrição |
|------|------|-----------|
| id_sistema | Integer | Identificador |
| nome | String | Nome do sistema |
| descricao | String | O que o sistema faz |
| nivelCriticidade | `BAIXO / MEDIO / ALTO` | Impacto do sistema |

### `SolicitacaoAcesso`
| Campo | Tipo | Descrição |
|------|------|-----------|
| id_acesso | Integer | Identificador |
| usuario | FK → Usuario | Quem solicitou acesso |
| sistema | FK → Sistema | Sistema desejado |
| aprovador | FK → Usuario | Quem aprovou/negou/revogou |
| status | `PENDENTE / APROVADO / NEGADO / REVOGADO` | Estado do pedido |
| dataSolicitacao | LocalDate | Quando foi criada |
| dataDecisao | LocalDate | Quando foi tomada a decisão |

---

## 🔐 Segurança

As senhas são **criptografadas com BCrypt** automaticamente no cadastro.

Exemplo de campo de senha no banco → `\$2a$10$O4Y...`

---

## 🌐 Endpoints Principais

### 👤 Usuários
| Método | URL | Descrição |
|------|------|------------|
| POST | `/usuarios` | Cria usuário |
| GET | `/usuarios/{id}` | Busca usuário por ID |

**Exemplo de criação de usuário**


POST /usuarios
{
  "nome": "João Silva",
  "email": "joao@empresa.com",
  "cargo": "Analista",
  "role": "USER",
  "senha": "123456"
}

| Método | URL              | Descrição    |
| ------ | ---------------- | ------------ |
| POST   | `/sistemas`      | Cria sistema |
| GET    | `/sistemas`      | Lista todos  |
| GET    | `/sistemas/{id}` | Busca por ID |

POST /sistemas
{
  "nome": "Portal RH",
  "descricao": "Consulta e gestão de folha de pagamento",
  "nivelCriticidade": "ALTO"
}

| Método | URL                          | Descrição                            |
| ------ | ---------------------------- | ------------------------------------ |
| POST   | `/solicitacoes`              | Cria nova solicitação                |
| GET    | `/solicitacoes`              | Lista todas                          |
| GET    | `/solicitacoes/pendentes`    | Lista solicitações pendentes         |
| GET    | `/solicitacoes/meus`         | Lista solicitações do usuário logado |
| PUT    | `/solicitacoes/{id}/aprovar` | Aprovar solicitação                  |
| PUT    | `/solicitacoes/{id}/negar`   | Negar solicitação                    |
| PUT    | `/solicitacoes/{id}/revogar` | Revogar um acesso aprovado           |

POST /solicitacoes
{
  "idUsuario": 1,
  "idSistema": 2
}

🛢 Banco de Dados

O projeto utiliza Spring Data JPA, podendo conectar a:

MySQL

PostgreSQL

Aiven

Configuração via application.properties.

📦 Tecnologias Usadas

Java 17+

Spring Boot

Spring Web

Spring Data JPA

Spring Security (para autenticação básica)

BCrypt Password Encoder

Gradle

👨‍💻 Autor

Projeto desenvolvido por Nelson como parte de estudo e preparação prática para entrevistas, desafios e hackathons.

Se quiser contribuir, melhorar ou refatorar — pull requests são bem-vindos 😉
