Av3poo3
Este é um sistema de gerenciamento integrado, desenvolvido em Java com Spring Boot, para gerenciar alunos e suas informações. O sistema utiliza PostgreSQL como banco de dados e Docker para orquestrar os containers.

Funcionalidades
Cadastro de Alunos: Permite criar, editar, consultar e excluir alunos.
Integração com Banco de Dados: Utiliza PostgreSQL para armazenar os dados dos alunos.
Dockerização: A aplicação e o banco de dados estão configurados para rodar em containers Docker.
Tecnologias Utilizadas
Java (Versão 21)
Spring Boot (Framework Java)
PostgreSQL (Banco de Dados Relacional)
Docker (Containerização)
Pré-Requisitos
Certifique-se de ter os seguintes pré-requisitos instalados em seu ambiente:

Java 21 ou superior
Docker
Postman (opcional, para testar a API)
Como Rodar o Projeto
1. Clonar o Repositório
Primeiro, clone este repositório para sua máquina local:

bash
Copiar código
git clone https://github.com/seu-usuario/av3poo3.git
cd av3poo3
2. Configuração do Docker
Este projeto utiliza Docker para rodar os serviços de aplicação e banco de dados. Antes de iniciar, verifique se o Docker está rodando em sua máquina.

Arquivo .env
Crie um arquivo .env no diretório raiz do projeto e defina as variáveis de ambiente necessárias:

env
Copiar código
POSTGRES_USER=seu_usuario
POSTGRES_PASSWORD=sua_senha
POSTGRES_DB=nome_do_banco
POSTGRES_LOCAL_PORT=5432
POSTGRES_DOCKER_PORT=5432
SPRING_LOCAL_PORT=8082
SPRING_DOCKER_PORT=8082
3. Construção e Execução com Docker Compose
Com o Docker configurado, execute o comando a seguir para construir e iniciar os containers:

bash
Copiar código
docker-compose up --build
Isso criará e iniciará dois containers:

PostgreSQL (banco de dados)
Aplicação Java Spring Boot
4. Acessar a Aplicação
Depois de rodar o docker-compose, a aplicação estará acessível na seguinte URL:

arduino
Copiar código
http://localhost:8082
5. Testar a API com o Postman
Você pode usar o Postman para testar os seguintes endpoints da API:

GET /alunos: Lista todos os alunos.
GET /alunos/{id}: Obtém um aluno pelo ID.
POST /alunos: Cria um novo aluno.
PUT /alunos/{id}: Atualiza um aluno existente.
DELETE /alunos/{id}: Deleta um aluno.
Exemplo de requisição para criar um aluno (POST /alunos):

json
Copiar código
{
    "nome": "João Silva",
    "idade": 20,
    "curso": "Ciência da Computação"
}
Estrutura do Projeto
A estrutura do projeto é organizada da seguinte maneira:

bash
Copiar código
av3poo3/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── av3poo3/
│   │   │           ├── Av3poo3Application.java        # Classe principal do Spring Boot
│   │   │           ├── controllers/                    # Controladores da API
│   │   │           ├── model/                          # Modelos de dados (Aluno.java)
│   │   │           └── repositories/                   # Repositórios (AlunoRepository.java)
│   │   ├── resources/
│   │   │   ├── application.properties                 # Configurações do Spring Boot
│   │   │   └── application.yml                        # Configurações do banco de dados
│   ├── test/
│   │   └── java/com/av3poo3/av3poo3/Av3poo3ApplicationTests.java # Testes automatizados
├── Dockerfile                                           # Dockerfile para construir a imagem
├── docker-compose.yml                                   # Configuração do Docker Compose
└── .env                                                 # Variáveis de ambiente para o Docker
Problemas Conhecidos
Caso o Docker esteja utilizando um sistema operacional diferente, pode haver problemas de quebra de linha (LF/CRLF). Certifique-se de configurar corretamente o Git ou usar a opção core.autocrlf para evitar conflitos.
Contribuições
Sinta-se à vontade para contribuir com o projeto! Para isso, basta seguir os passos:

Faça um fork do repositório.
Crie uma branch para sua nova funcionalidade (git checkout -b minha-funcionalidade).
Realize as alterações.
Commit suas alterações (git commit -am 'Adiciona nova funcionalidade').
Envie para o repositório remoto (git push origin minha-funcionalidade).
Crie um Pull Request.
