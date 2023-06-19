# Projeto de Cadastro de pessoas
Projeto de Cadastro de pessoas (Desafio Técnico).

Foi utilizado DDD para garantir uma boa escalabilidade do projeto, as regras de negócio estão encapsuladas dentro das entidades. O código foi escrito tentando seguir ao máximo os principios **SOLID**.

#### Observações

É necessário ter instalado a JDK 17 (Devido ao Spring 3.1)

## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/thiagoyudji/cadastro.git
```

Entre no diretório do projeto

```bash
  cd cadastro
```
Com a JDK 17 Instalada rode o comando de build para preparar o projeto em sua máquina

```bash
  gradlew clean build
```

Execute o seguinte comando para executar a aplicação localmente

```bash
  java -jar ./build/libs/cadastro-0.0.1-SNAPSHOT.jar
```

## Documentação da API




#### Cria nova pessoa.

```http
  POST /api/pessoas
```

{
	"identificador":12345678910203,
	"nome":"Nome"
}

#### Lista todas as pessoas.
```http
  GET /api/pessoas
```

#### Swagger UI

```bash
  http://localhost:{$PORTA}/v1/swagger-ui.html
```
## Tecnologias utilizadas

 - [Java 17](hhttps://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
 - [Gradle](https://gradle.org/)
 - [SpringBoot](https://spring.io/projects/spring-boot)
 - [Spring Data JDBC](https://spring.io/projects/spring-data-jdbc)
 - [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
 - [Spring Doc Open API](https://springdoc.org/)
 - [PostgreSQL](https://www.postgresql.org/docs/)
 - [Lombok](https://projectlombok.org/)
 - [Hibernate + Validator](https://hibernate.org/validator/)

