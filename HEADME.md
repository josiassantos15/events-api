# events-api

API RESTful para gerenciamento de eventos.

## Funcionalidades

- Criar eventos
- Consultar eventos.
- Criar subscrição.
- Consultar subscrição.
- Gerar ranking e estatísticas.

## Tecnologias

- O microsserviço foi desenvolvido utilizando [Spring Boot 3](https://spring.io/projects/spring-boot)
  com [Java 21](https://www.oracle.com/java/technologies/downloads/#java17).
- Para controle de dependências e build foi utilizado [Maven](https://maven.apache.org/).
- Para documentação da API foi utilizado [Swagger](https://swagger.io/).
- Para execução do microsserviço em um container foi utilizado [Docker](https://www.docker.com/).

## Requisitos

Esse microsserviço pode ser executado localmente com Spring Boot ou utilizando um container Docker.

### Executar com Spring Boot

É necessário ter o [Java 21](https://www.oracle.com/java/technologies/downloads/#java17) e
o [Maven](https://maven.apache.org/) instalados em sua máquina.

Utilize sua IDE de preferência para executar o projeto ou execute o comando abaixo no diretório raíz do projeto:

```shell
mvn spring-boot:run
```

### Executar com Docker

Certifique-se de ter o [Docker](https://www.docker.com/get-docker) instalado em sua máquina.

Execute o projeto utilizando Docker Compose.

```shell
docker-compose up -d
```

### Iniciar Banco MySql
```shell
docker compose up -d
```