# Livraria API

Uma API desenvolvida com **Spring Boot** para gerenciar livros, autores, categorias e clientes de uma livraria. A aplicação está hospedada no **Render** e utiliza o **SQL Server** no **Azure** como banco de dados.

---

## 📚 Funcionalidades

- Gerenciamento de livros: criação, leitura, atualização e exclusão.
- Gerenciamento de autores e categorias.
- Cadastro de clientes.
- Endpoints RESTful para integração.

---

## 🚀 Tecnologias

- **Java 17**
- **Spring Boot 3.x**
- **SQL Server** (Azure)
- **Hibernate**
- **Render** (Deploy)
- **Maven** (Gerenciamento de dependências)

---

## 🛠 Configuração e Execução

### Pré-requisitos
- JDK 17+
- Maven
- SQL Server no Azure
- Conta no Render

---

##📂 Estrutura do Projeto

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── com.example.livraria/
│   │   │   ├── controller/    # Controladores REST
│   │   │   ├── domain/    # Modelos das entidades
│   ├── resources/
│   │   ├── application.properties  # Configuração da aplicação
```

---

## 🌐 Documentação

Acesse a documentação interativa no Swagger para visualizar e testar os endpoints:  

Swagger UI - Livraria API: https://apilivraria.onrender.com/swagger-ui/index.html

---

## 📓 Notebook de Exemplos

O arquivo Jupyter Notebook contendo exemplos de uso da API está disponível neste repositório. Você pode acessá-lo diretamente [aqui](./Api_livraria.ipynb).
Site para testar as requisições [aqui](https://lucasraulinosilva.github.io/livrariaJorge/index.html)

