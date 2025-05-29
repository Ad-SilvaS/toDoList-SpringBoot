📌 Visão Geral

API RESTful para gerenciamento de tarefas com funcionalidades completas de CRUD, filtros e ordenação. Desenvolvida com Spring Boot e Java.


🚀 Tecnologias

Java 17+

Spring Boot 3+

Spring Data JPA

H2 Database (ou outro banco configurável)

Validação de Dados

Tratamento de Exceções Global


🌟 Funcionalidades

✅ CRUD completo de tarefas

🔍 Busca por nome e prioridade

🎯 Atualização parcial dos campos

📊 Ordenação automática por prioridade e nome

🚨 Tratamento de erros personalizado


📋 Modelo de Dados
@Entity
@Table(name = "todos")
public class Todo {
    private Long id;                // ID único
    @NotBlank private String name;  // Nome da tarefa (obrigatório)
    @NotBlank private String description; // Descrição (obrigatória)
    private boolean accomplished;   // Status de conclusão
    private Integer priority;       // Nível de prioridade
}


🔗 Endpoints

Tarefas

Método	                    Endpoint	                         Descrição
POST	               /todos	                           Cria nova tarefa
GET	                   /todos	                           Lista todas (ordenadas por prioridade/nome)
GET	                   /todos/name?name={nome}	           Busca por nome (case insensitive)
GET	                   /todos/priority?priority=N	       Filtra por prioridade
PUT	                   /todos/{id}/update-name             Atualiza nome
PUT	                   /todos/{id}/update-desc	           Atualiza descrição
PUT	                   /todos/{id}/update-priority	       Altera prioridade
PUT	                   /todos/{id}/update-accomplished	   Marca/desmarca como concluída
DELETE	               /todos/{id}	                       Remove tarefa


⚙️ Configuração

Pré-requisitos
Java 17+
Maven
Banco de dados configurado (application.properties)

Execução
mvn spring-boot:run


🛠️ Exemplos de Uso

Criar tarefa
POST /todos
Content-Type: application/json

{
    "name": "Estudar Spring",
    "description": "Criar projeto ToDo List",
    "priority": 1
}

Atualizar status
PUT /todos/1/update-accomplished?accomplished=true

Buscar por prioridade
GET /todos/priority?priority=1


🔒 Tratamento de Erros

A API retorna respostas padronizadas para erros:
{
    "timestamp": "2023-11-20T12:34:56Z",
    "status": 404,
    "error": "Not Found",
    "message": "Not Found! No results for id: 99",
    "path": "/todos/99"
}


📦 Estrutura do Projeto
src/
├── main/
│   ├── java/
│   │   └── br/com/dgg/todolist/
│   │       ├── controller/        # Controladores REST
│   │       ├── entity/            # Entidades JPA
│   │       ├── repository/        # Repositórios Spring Data
│   │       ├── service/           # Lógica de negócio
│   │       └── exception/         # Tratamento de erros
│   └── resources/                 # Configurações
└── test/                          # Testes