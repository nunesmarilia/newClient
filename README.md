## Cadastro de Clientes

Projeto para estudo springboot com MongoDB

## REST API

http://x:9001/ml/swagger-ui.html

## Serviço do cadastro de clientes

http://x:9001/ml/newClient

* Passar Json 
{
"name": ["Full Name"],
"address": [XX],
"cpf": [999.999.999-99]
}


## Build manual com Testes

`mvn install -Dmaven.test.skip=false`

## Build manual sem Testes

`mvn install -Dmaven.test.skip=true`