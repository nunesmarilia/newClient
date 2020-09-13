package com.mn.newclient.controller;

import com.mn.newclient.model.Clients;
import com.mn.newclient.repository.ClientsRepository;
import com.mn.newclient.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Cadastro de clientes", description = "Estudo springboot + MongoDB")
public class ClientsRestController {

    @Autowired
    ClientsRepository clientRepository;

    @ApiOperation(value = "Cadastro de novos clientes")
    @PostMapping("/save")
    public ResponseEntity<String> newClient(@RequestBody Clients client) {
        System.out.println("Entrou no método save");

        try {
            // Validação do cpf
            if( !Util.isCPF(client.getCpf()) )
                return new ResponseEntity<>("Cpf inválido", HttpStatus.FORBIDDEN);

            clientRepository.save(client);

        }catch (Exception e){
            return new ResponseEntity<>("Houve algum problema na criação do cliente", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Cliente criado com sucesso", HttpStatus.OK);
    }

    @ApiOperation(value = "Busca de cliente por cpf")
    @GetMapping(path="/findCpf/{cpf}")
    public ResponseEntity<Clients> findClientFilterCPF(@PathVariable String cpf){
        Optional<Clients> client = clientRepository.findById(cpf);

        System.out.println("Entrou no método findCpf");

        return client.map(cli -> ResponseEntity.ok(cli))
                .orElse(ResponseEntity.noContent().build());
    }

    @ApiOperation(value = "Visualização da lista dos clientes cadastrados")
    @GetMapping(path="/listAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Clients> listAll()  {
        return clientRepository.findAll();
    }

}
