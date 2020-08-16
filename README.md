# Persistencia-JPA-REDIS

 Spring Data JPA + Cache Redis (os dois em um único projeto). 
 
## Rodando o projeto

### Subindo base de dados e redis no docker
Na raiz do projeto existe o arquivo docker-compose.yml que carrega o seguinte:
 - mysql 8 na porta 3306
 - redis na porta 6379
 - adminer para visualizar o banco de dados na porta 8081

Subindo a base do projeto, estando na raiz no projeto, execute:

        $ docker-compose up -d

Após subir o banco na primeira vez, será necessário criar a database `persistence`
Entre no http://localhost:8081/ 
- UserName : root
- Password : Se encontra no application.properties

Host - http://localhost:8081/?server=db&username=root&db=&schema=
 Cliente em Create Database
 crie um schema "persistence" Ou Use suas configuracoes locais
 
### O Projeto
O projeto é exposto na porta `8080`.
Para iniciar o projeto usando maven rode o seguinte comando depois de subir banco e redis.

        $ mvn spring-boot:run


Swagger -> http://localhost:8080/swagger-ui.html
adminer -> http://localhost:8081/

 
# Regras

 - O portal possui vários produtos em estoque e com uma determinada quantidade em estoque de cada um desses produtos.
 - Cada pedido possui um ou mais produtos e um cliente associado a esse pedido. [OK]
 - Um produto pode aparecer em um ou mais pedidos. [OK]
 - Cada produto possui um código, um nome, uma quantidade e um valor. [OK]
 - Cada cliente possui seus dados pessoais e dados de entrega. [OK]
 
 
 # Importante para devs do grupo
 
 - Remover a implementacao CommandLineRunner no metodo main apos construir as controllers
 - Criar um schema com o nome "persistence" no banco local
 - Alterar usuario e senha no application.properties
 
 
 # Lembrar
 
  DDL Mode esta para -> create-drop
