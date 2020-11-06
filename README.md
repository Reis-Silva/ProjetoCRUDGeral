# ProjetoCRUDGeral
Projeto de Cadastro Geral sem ferramenta hibernate, podendo ser utilizado como base generica para a fundamentação CRUD de banco de dados. 

## Features

- Suporte no JavaSE-8 em diante podendo ser utilizado o jdk nas versões `8.x e 11.x`;

- Suporte no Servidor Apache Tomcat versões `7.x, 8.x, 9.x`, aconselhável a versão `9.x` - Link: https://downloads.apache.org/tomcat/tomcat-9/v9.0.39/bin/apache-tomcat-9.0.39-windows-x64.zip;

- Dados recorrentes de dependencias do projeto podem ser utilizadas de acordo como está definido no Link do pom.xml: https://github.com/Reis-Silva/ProjetoCRUDGeral/blob/main/projetobrainiacX/pom.xml desde de que esteja dentro das versões do JavaSE.

## Observações:

#### OBS: Possível realizar modificações generalizadas para qualquer outro tipo de modelo;

#### OBS2: Utilizada a conexão com MySQL;

#### OBS3: Crie no MySQL o banco de dados "genericbd", com as "TABLES" "carro" e "usuarios", ou modifique o nome dentro do banco de dados na classe "FabricaConexão" e as "TABLES" "carro" e "usuarios" nas classes "CarroCRUD" e "UsuarioCRUD" respectivamente;

#### OBS4: Usuário: root | Senha: 1234.
