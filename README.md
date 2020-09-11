## Cadastro de Clientes

Projeto para estudo springboot com MongoDB

## REST API

http://x:9001/newclient/swagger-ui.html

## Serviço do cadastro de clientes

http://x:9001/newclient/save

* Passar Json 
{
"name": ["Full Name"],
"address": [XX],
"cpf": [99999999999]
}


## Build manual com Testes

`mvn install -Dmaven.test.skip=false`

## Build manual sem Testes

`mvn install -Dmaven.test.skip=true`