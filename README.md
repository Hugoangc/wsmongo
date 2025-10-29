# API de Blog com Spring Boot e MongoDB (wsmongo)

O projeto é uma API RESTful desenvolvida em Java, Spring Boot, utilizando MongoDB como banco de dados. O intuito é simulra o backend de um sistema de blog, permitindo o gerenciamento de usuários, posts e comentários.

Projeto construído com intuíto de ser uma parte de estudos sobre desenvolvimento backend, com boas práticas de API REST, arquitetura em camadas (Controller, Service, Repository), uso de DTOs e consultas usando o Spring Data MongoDB.

---

## Funcionalidades

* **Usuários (Users):** CRUD 
* **Posts:** CRUD  para posts.
* **Comentários:** Adição de comentários (DTOs) dentro dos posts.
* **Busca (Full Search):** Um endpoint de busca avançada (`/posts/fullsearch`) que permite filtrar posts por:
    * Texto (case-insensitive) no título, corpo ou nos comentários.
    * Intervalo de datas (data mínima e data máxima).

---

## Tecnologias:

* **Java 17.0.5**
* **Spring Boot**
    * Spring Web (RESTful APIs)
    * Spring Data MongoDB (Integração com o banco)
    * Spring Boot DevTools
* **MongoDB** (NoSQL)
* **Maven** (Gerenciador de dependências e build)
* **Padrão de Camadas** (Resource, Service, Repository)
* **Padrão DTO** (Data Transfer Object)
* **Tratamento de Exceções**


### Diagrama de classe:
<img src="https://i.imgur.com/yLQTiI2.png" alt="diagrama de classe">
