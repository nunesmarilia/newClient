package com.mn.newclient.controller;

import com.mn.newclient.model.Client;
import com.mn.newclient.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@Api(value = "Cadastro de clientes", description = "Estudo springboot ")
public class ClientRestController {

	@Autowired
	ClientRepository clientRepository;

//	@ApiOperation(value = "Cadastro de novos clientes")
	@PostMapping("/newClient")
	public ResponseEntity<String> newClient(@RequestBody Client client) {

		try {
			// Validação do cpf
			//this.isValidCpf(client.getCpf());

			clientRepository.save(client);

		}catch (Exception e){
			return new ResponseEntity<>("HTTP 500", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<>("HTTP 201-CREATED", HttpStatus.CREATED);
	}

	@GetMapping(path="/{cpf}")
	public ResponseEntity<Client> view(@PathVariable String cpf){

		Optional<Client> client = clientRepository.findById(cpf);

		return client.map(cli -> ResponseEntity.ok(cli))
				.orElse(ResponseEntity.noContent().build());
	}

	// Validação do cpf do cliente
	public void isValidCpf(String cpf) throws Exception{
		throw new Exception();
	}

}
