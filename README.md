## Cadastro de Clientes

Projeto para estudo springboot com MongoDB

### Observações
Para subir o ambiente corretamente é necessário executar os passos do build maven e depois executar o docker-compose

## REST API

http://lochost/managerClient/swagger-ui.html

## Serviço do cadastrar clientes
http://localhost/managerClient/save

* Passar Json 
{
"name": "Full Name",
"address": "XX",
"cpf": "99999999999"
}

## Serviço de listar de clientes cadastrados
http://localhost/managerClient/listAll

## Serviço de pesquisar cpf
http://localhost/managerClient/find/{cpf}

## Build manual com Testes

`mvn install -Dmaven.test.skip=false`

## Build manual sem Testes

`mvn install -Dmaven.test.skip=true`

## Subindo ambiente Docker
```bash
docker-compose up --build -d
```

## Subindo ambiente Docker pra nuvem
```bash
#!/bin/bash

# Description: Baixa projeto e inicia o docker
# Author: Marilia Nunes Alves

WORK_DIR=/opt/application
[ ! -d "${WORK_DIR}" ] && sudo mkdir ${WORK_DIR} && sudo chown $(whoami): ${WORK_DIR}

cd ${WORK_DIR}

if [ ! -d "${WORK_DIR}/newclient" ]; then
	git clone https://github.com/nunesmarilia/newclient.git
	cd newclient
else
	cd ${WORK_DIR}/newclient
	git pull
fi

mvn clean install

cd target
docker-compose up --build -d
```