# Ambiente
- Java 8, Maven
- MySql
### Subindo local
- Instale o MySql, Java jdk 8, Maven;
- Altere o arquivo `application.properties` apontando para seu banco Mysql;
- Faça um `mvn clean install`;
-  Acesse a pasta `target` e execute o programa com o comando `java -jar br.com.bureau-1.0.0.jar`
### Subindo na AWS
- Acessar a WS console;
- Criar um banco de dados RDS MySql;
- Criar uma maquina EC2 Linux e instalar o Java jdk 8, Maven;
- Clone o repositório para o EC2;
- Altere o `application.properties` para apontar para o seu RDS
- Clone o repositório, rode um `mvn clean install`,
- Acesse a pasta `target` e execute o programa com o comando `java -jar br.com.bureau-1.0.0.jar`
### Instruções de utilização
 - Os endpoints estão disponíveis aqui: [Coleção do Postman](https://raw.githubusercontent.com/Jessicammelo/bureau/master/bureau.postman_collection.json)

### Arquitetura
![enter image description here](https://github.com/Jessicammelo/bureau/blob/master/Arquitetura.png?raw=true)

-A imagem da arquitetura mostra as camadas do projeto, onde a API Rest é a camada de controladores que repassa para a camada de serviços onde a chamada é processada e encaminhada para o repository onde será salvo no banco de dados.

### Modelagem
![enter image description here](https://github.com/Jessicammelo/bureau/blob/master/Modelagem.png?raw=true)