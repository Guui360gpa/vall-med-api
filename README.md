# 🩺 Vall-Med API

API REST para o gerenciamento de um consultório médico, desenvolvida com **Java** e **Spring Boot**. Centraliza o cadastro de médicos e pacientes e o agendamento de consultas, aplicando regras de negócio e validações.

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Maven](https://img.shields.io/badge/Maven-build-C71A36)

<!-- CONFIRMAR: versão do Java e do Spring Boot no pom.xml; ajuste os badges. Adicione badges do banco (MySQL/PostgreSQL) conforme o que usa. -->

---

## 📑 Sumário

- [Sobre o projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Tecnologias](#-tecnologias)
- [Arquitetura](#-arquitetura)
- [Regras de negócio](#-regras-de-negócio)
- [Como executar](#-como-executar)
- [Endpoints](#-endpoints)
- [Tratamento de erros](#-tratamento-de-erros)
- [Testes](#-testes)
- [Próximos passos](#-próximos-passos)
- [Autor](#-autor)

---

## 📖 Sobre o projeto

O **Vall-Med** é uma API back-end para a rotina administrativa de um consultório médico. Ela substitui controles manuais por um sistema que registra profissionais e pacientes e organiza o agendamento de consultas, garantindo que as regras do consultório sejam respeitadas.

<!-- CONFIRMAR: ajuste este parágrafo ao que o projeto realmente faz. -->

## 📌 Funcionalidades

<!-- CONFIRMAR: deixe apenas o que está implementado. -->

- 👨‍⚕️ Cadastro, listagem, atualização e exclusão lógica de **médicos**
- 🧑 Cadastro, listagem, atualização e exclusão lógica de **pacientes**
- 📅 **Agendamento** de consultas
- ❌ **Cancelamento** de consultas, com motivo
- ✅ Validação dos dados de entrada

## 🚀 Tecnologias

| Tecnologia | Uso |
|---|---|
| **Java** | Linguagem principal |
| **Spring Boot** | Framework da aplicação |
| **Maven** | Gerenciamento de dependências e build (wrapper `mvnw` incluído) |
| **Spring Data JPA** | Persistência de dados |
| **Bean Validation** | Validação dos dados de entrada |

<!-- CONFIRMAR: só Maven está comprovado pelo repositório. Confira o pom.xml e acrescente/remova linhas, por exemplo:
     MySQL ou PostgreSQL, Flyway, Spring Security + JWT, Lombok, SpringDoc (Swagger), JUnit/Mockito. -->

## 🏗️ Arquitetura

```
Controller  →  Service/Domain  →  Repository  →  Banco de dados
```

<!-- CONFIRMAR: descreva a organização real dos pacotes em src/main/java (controller, domain, repository, infra...). -->

## 📏 Regras de negócio

<!-- CONFIRMAR: liste as regras que de fato validou no código. Exemplos comuns neste tipo de projeto: -->

- Uma consulta só pode ser agendada para um médico e um paciente ativos
- O horário da consulta deve respeitar o horário de funcionamento do consultório
- Não é permitido agendar duas consultas para o mesmo médico no mesmo horário
- Um paciente não pode ter duas consultas no mesmo dia
- O cancelamento exige antecedência mínima e um motivo

## ▶️ Como executar

### Pré-requisitos

- [Java 17+](https://adoptium.net/)
- Banco de dados configurado <!-- CONFIRMAR: qual banco -->

### Passo a passo

**1. Clone o repositório**

```bash
git clone https://github.com/Guui360gpa/vall-med-api.git
cd vall-med-api
```

**2. Configure a conexão com o banco** em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:<banco>://localhost:<porta>/<nome_do_banco>
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
```

<!-- CONFIRMAR: URL e propriedades reais do seu projeto. -->

> 🔒 Use variáveis de ambiente para credenciais e nunca envie senhas reais ao repositório.

**3. Execute a aplicação**

```bash
./mvnw spring-boot:run
```

No Windows: `mvnw.cmd spring-boot:run`. A API sobe em **http://localhost:8080**.

## 🔌 Endpoints

<!-- CONFIRMAR: substitua pelas rotas reais dos seus controllers. Modelo: -->

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/medicos` | Cadastra um médico |
| `GET` | `/medicos` | Lista médicos |
| `PUT` | `/medicos` | Atualiza dados de um médico |
| `DELETE` | `/medicos/{id}` | Inativa um médico |
| `POST` | `/pacientes` | Cadastra um paciente |
| `GET` | `/pacientes` | Lista pacientes |
| `POST` | `/consultas` | Agenda uma consulta |
| `DELETE` | `/consultas` | Cancela uma consulta |

## ⚠️ Tratamento de erros

<!-- CONFIRMAR: descreva o formato das respostas de erro, se houver tratamento global. -->

Erros de validação e de regra de negócio retornam o status HTTP adequado (`400`, `404`, `422`) com mensagem descritiva.

## 🧪 Testes

<!-- CONFIRMAR: se houver testes, mantenha; caso contrário, mova para "Próximos passos". -->

```bash
./mvnw test
```

## 🔭 Próximos passos

- [ ] Documentação interativa com Swagger/OpenAPI
- [ ] Autenticação e autorização com Spring Security + JWT
- [ ] Testes unitários e de integração
- [ ] Containerização com Docker
- [ ] Deploy em ambiente público

## 👨‍💻 Autor

**Guilherme Paiva Alves** — [@Guui360gpa](https://github.com/Guui360gpa)
