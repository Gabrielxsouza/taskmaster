# TaskMaster API

> Projeto para a disciplina de **APIs e Microsserviços 2025.2**

## Sobre a aplicação

Este é o backend de um sistema de gerenciamento de tarefas, o TASKMASTER. É uma API RESTful desenvolvida para criar, organizar e gerenciar uma lista de tarefas.

## Funcionalidades da API

* **Gerenciamento de Tarefas**: Criar, atualizar e deletar tarefas.
* **Listagem Completa**: Listar todas as tarefas com sistema de paginação e ordenação.
* **Filtro por Categoria**: Visualizar apenas as tarefas de uma categoria específica (ex: "Trabalho", "Estudo").

## Tecnologias utilizadas

* Java 17
* Spring Boot 3
* Maven
* H2 Database (Banco de Dados em Memória)

## Como Executar

**1. Pré-requisitos:**
* Java 17 (JDK)
* Apache Maven

**2. Iniciar a aplicação:**
No terminal, dentro da pasta do projeto, execute o comando:
```bash
mvn spring-boot:run
```

## Endpoints e Documentação

Com a aplicação rodando, acesse os links abaixo:

* **Documentação da API (Swagger UI)**:
    * `http://localhost:8080/swagger-ui.html`

* **Console do Banco de Dados (H2)**:
    * `http://localhost:8080/h2-console`
    * **JDBC URL**: `jdbc:h2:mem:taskmasterdb`

## Autores :) 

* **Gabriel de Souza Costa**
* **Maria Eduarda Alves Selvatti**
* **IFSP - Campus Guarulhos**
* *6º Semestre - Engenharia da Computação*
