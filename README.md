# Módulo 2.1 PMP

Módulo 2.1 do Projeto de PMP para entrega do Projeto Final, nele foi atendido os seguintes requisitos:

```
Módulo 2

Crie uma API REST de Login com controle de acesso por usuário e senha.

Requisitos:

Ao enviar um usuário e senha válidos, o sistema deve retornar, através do endpoint /login, um token de autenticação (Bearer Token).

O container da aplicação de Login não deve expor sua porta diretamente (configure o Docker adequadamente).

Inclua o Dockerfile necessário para a construção da aplicação.
```

### Observação
* **Para o projeto complementar do 2° módulo, temos essa e outros dois projetos  que contemplam esse desenvolvimento**

| Projeto   | Descrição                         | Link do Repositório                                                |
|-----------|-----------------------------------|--------------------------------------------------------------------|
| Módulo 1  | API Rest com Crud Pessoa          | [Módulo 1](https://github.com/VekRest/vekrest-vekclient-modulo1)   |
| Módulo 2  | Gateway das aplicações do projeto | (em desenvolvimento)                                               |
| Módulo 2.1 | API Rest de Login + Segurança     | Este Repositório                                                   

---

---

## 📘 Estrutura do Projeto

```
📂 modulo-auth/
├── 📁 .github ← Workflows e CI/CD
├── 📁 .idea ← Configurações da IDE
├── 📁 domain ← Módulo de domínio Java puro
│ ├── entity/ ← Entidades do domínio (Usuário, Token, etc.)
│ └── repository/ ← Interfaces de persistência
├── 📁 springframework ← Módulo Spring Boot
│ ├── configuration/ ← Configurações e Beans (Security, JWT, etc.)
│ ├── controller/ ← Controllers REST
│ │ ├── adapter/ ← Adaptadores DTO ↔ Entidade
│ │ ├── execption/ ← Exceções customizadas
│ │ ├── logging/ ← Filter de CorrelationId / Logs
│ │ └── repository/ ← Implementações da persistência
│ ├── security/ ← Configuração de segurança, filtros JWT
│ └── Modulo21Application.java ← Classe principal Spring Boot
├── 📁 src/main/resources ← Configurações e logs
│ ├── application.properties
│ └── logback-spring.xml
├── 📁 src/test/ ← Testes unitários e de integração
├── 📁 target/ ← Build compilado
├── 📄 pom.xml ← Build Maven do módulo
├── 📄 docker-compose.yml ← Configuração dos containers (Mongo, Redis, Graylog, etc.)
├── 📄 Dockerfile ← Build da imagem da aplicação
├── 📄 LICENSE ← Licença do projeto
├── 📄 README.md ← Documentação do projeto
├── 📄 .gitignore ← Arquivos e pastas ignorados pelo Git
└── 📄 .gitattributes ← Configurações de atributos do Git
````
## 🧩 Tecnologias Utilizadas

- **Spring Boot** → Framework Back-End
- **Java** → Linguagem de programação
- **Maven** → Build
- **Docker** → Containers e virtualização
- **MongoDB** → Persistência de dados
- **Redis** → Cache
- **SonarQube** → Qualidade do Código
- **Github Actions** → CI/CD automatizado

---

## ✅ Qualidade de Código (SonarQube)

> A Qualidade de Código do Projeto é Analisada através do SonarQube, verifique os badges a seguir que apresentam as métricas obtidas no projeto!

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo2.2&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo2.2)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo2.2&metric=bugs)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo2.2)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo2.2&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo2.2)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo2.2&metric=coverage)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo2.2)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo2.2&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo2.2)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo2.2&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo2.2)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo2.2&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo2.2)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo2.2&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo2.2)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo2.2&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo2.2)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo2.2&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo2.2)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=PMP-Projects_modulo2.2&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=PMP-Projects_modulo2.2)

---

## 📦 Instalação e Configuração do Ambiente

### 1️⃣ Clone o projeto na sua máquina e baixe as dependências:
```bash
# Clonar repositório
git clone https://github.com/PMP-Projects/modulo2.1.git

# Acesse a pasta do projeto
cd modulo2.1
````

### 2️⃣ Suba os Containers e Rode a Aplicação
```bash
# Inicie os containers (MongoDB, Redis, OpenSearch, Graylog), juntamente com o Dockerfile da aplicação
docker compose up -d --build
```

#### Serviços do Docker Compose

Caso queira acessar o gerenciamento de logs ou a base de dados do MongoDB, você pode utilizar esses acessos
- MongoDB: localhost:27017


## 📦 Esteira CI/CD com Github Actions

A esteira CI/CD deste projeto é automatizada via Github Actions.

###  Etapas da Esteira:
1️⃣ Verificação de **Vulnerabilidades** com o **Trivy**

2️⃣ Análise de qualidade de código com **Sonar Cloud**

---
## Endpoints 

| Método   | Endpoint             | Descrição                                |
|----------|----------------------|------------------------------------------|
| `POST`   | `/api/v1/auth/login` | Login do usuário criado para gerar token |
| `POST`   | `/api/v1/user/save`  | Salvar conta inserindo usuário e senha   |

### Exemplos de uso com cURL

* Obs.: cURLs exportados do Insomnia

#### Criar Conta

```bash 
curl --request POST \
  --url http://localhost:8082/api/v1/user/save \
  --header 'Content-Type: application/json' \
  --data '{
  "username": "juliuses",
  "password": "123456"
}'
````

#### Login

```bash 
curl --request POST \
  --url http://localhost:8082/api/v1/auth/login \
  --header 'Content-Type: application/json' \
  --data '{
  "username": "juliuses",
  "password": "123456"
}
'
````


## ✍️ Autor do Projeto

<div align="center">

| [<img src="https://avatars.githubusercontent.com/u/99426563" width=115><br><sub>Júlio Neves</sub>](https://github.com/juliosn)
| :---: |

</div>

---
