# 📘 Projeto IADSN

Este é um projeto Spring Boot desenvolvido com o objetivo de automatizar processos feitos por igrejas, com validação de dados e uma interface web com Thymeleaf.

---

## 📋 Sumário

- [🛠 Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [🚀 Funcionalidades](#-funcionalidades)
- [📂 Estrutura do Projeto](#-estrutura-do-projeto)
- [⚙️ Pré-requisitos](#️-pré-requisitos)
- [🚧 Como Executar o Projeto](#-como-executar-o-projeto)
- [💻 Autor](#-autor)

---

## 🛠 Tecnologias Utilizadas

Este projeto foi desenvolvido com as seguintes tecnologias:

- **Spring Boot 3.4.0**
- **Java 17**
- **Spring Data JPA** (com Hibernate)
- **Spring Web**
- **Spring Security**
- **MySQL Driver**
- **Thymeleaf** (Template Engine)
- **Lombok**

---

## 🚀 Funcionalidades

- Cadastro e validação de dados do usuário.
- Tesouraria e geração de relatórios.
- Emissão de carteirinhas e contrato de aluguel.
- Persistência de dados utilizando MySQL e Spring Data JPA.
- Renderização de páginas dinâmicas com Thymeleaf.
- Integração com banco de dados para gerenciamento de informações.

---

## ⚙️ Pré-requisitos

Antes de começar, você precisará ter as seguintes ferramentas instaladas no seu ambiente de desenvolvimento:

- **Java 17** ou superior
- **Maven 3.8+**
- **MySQL** (ou outro banco compatível)
- **Git** (para controle de versão)

---

## 🚧 Como Executar o Projeto

1. **Clone este repositório**:
   ```bash
   git clone https://github.com/seu-usuario/iadsn.git
   Acesse o diretório do projeto:

   bash
   Copiar código
   cd iadsn
   Configure o banco de dados:
  
   Crie um banco de dados no MySQL com o nome, por exemplo, iadsn_db.
   Execute o arquivo .sql (insert-login.sql) para ter acesso ao sistema com Login: admin, senha: 123
   Atualize o arquivo application.properties localizado em src/main/resources com as configurações do banco de dados:
   properties
   Copiar código
   spring.datasource.url=jdbc:mysql://localhost:3306/iadsn_db
   spring.datasource.username=SEU_USUARIO
   spring.datasource.password=SUA_SENHA
   spring.jpa.hibernate.ddl-auto=update
   Instale as dependências do projeto: Use o Maven para baixar e configurar as dependências necessárias:
  
   bash
   Copiar código
   mvn clean install
   Inicie a aplicação: Execute o servidor Spring Boot:
  
   bash
   Copiar código
   mvn spring-boot:run
   Acesse a aplicação: Abra o navegador e vá para o endereço: http://localhost:8080
   ```
## 💻 Autor

Desenvolvido por **Josué Vítor** 🚀

- [LinkedIn](https://www.linkedin.com/in/jvfrancalisboa/)
- [GitHub](https://github.com/JVFrancaLisboa)
- Email: josuevitorfrancalisboa@gmail.com
