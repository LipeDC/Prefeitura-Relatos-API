# Sobre o projeto
Este projeto foi uma ideia própria que implementei para praticar e consolidar meus conhecimentos em Java, Spring Boot e desenvolvimento backend.

# Prefeitura Relatos API

API REST desenvolvida em Java com Spring Boot para o gerenciamento de relatos de problemas urbanos. Usuários podem registrar problemas da cidade (como buracos, pichações, iluminação, lixo etc.) e a prefeitura pode visualizar e gerenciar esses relatos.

## Funcionalidades

- Cadastro de usuários (com roles de USUARIO e ADMIN)
- Registro de relatos vinculados a usuários
- Listagem, atualização (PUT) e exclusão (DELETE) de relatos
- Validação básica de dados com DTOs e Bean Validation
- Relacionamento entre usuários e relatos (ManyToOne)

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Banco de dados H2 
- Maven
- Lombok
