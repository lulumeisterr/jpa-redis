# Persistencia-JPA-REDIS

 Spring Data JPA + Cache Redis (os dois em um único projeto). 
 
# Regras

 - O portal possui vários produtos em estoque e com uma determinada quantidade em estoque de cada um desses produtos.
 - Cada pedido possui um ou mais produtos e um cliente associado a esse pedido.
 - Um produto pode aparecer em um ou mais pedidos.
 - Cada produto possui um código, um nome, uma quantidade e um valor.
 - Cada cliente possui seus dados pessoais e dados de entrega. 
 
 
 # Importante para devs do grupo
 
 - Remover a implementacao CommandLineRunner no metodo main 
 - Criar um schema com o nome ˜persistence˜ no banco local
 - Altear usuario e senha no application.properties
 
 
 # Lembrar
 
  DDL Mode esta para -> create-drop
